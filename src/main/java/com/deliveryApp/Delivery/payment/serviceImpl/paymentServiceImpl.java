package com.deliveryApp.Delivery.payment.serviceImpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.deliveryApp.Delivery.exception.NotFoundException;
import com.deliveryApp.Delivery.payment.dto.ConfigurationWompiDto;
import com.deliveryApp.Delivery.payment.dto.RequestPayment;
import com.deliveryApp.Delivery.payment.dto.RequestWompi;
import com.deliveryApp.Delivery.payment.dto.ResponseTokenWompi;
import com.deliveryApp.Delivery.payment.dto.TarjetaRequest;
import com.deliveryApp.Delivery.payment.model.tokenPayment;
import com.deliveryApp.Delivery.payment.repository.tokenPayRepository;
import com.deliveryApp.Delivery.payment.service.paymentService;
import com.deliveryApp.Delivery.user.model.user;
import com.deliveryApp.Delivery.user.repository.UsuarioRepository;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


@Service
public class paymentServiceImpl implements paymentService{
	
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UsuarioRepository usuarioRepo;
	
	@Autowired
	private tokenPayRepository tokenRepo;

	@Override
	public String payment(RequestPayment payment) {
		RestTemplate restTemplate = new RestTemplate();
		String fooResourceUrl	  = "https://api.wompi.sv/TransaccionCompra";
		
		RequestWompi wompi = new RequestWompi();
		wompi.setTarjetaCreditoDebido(modelMapper.map(payment, TarjetaRequest.class));
		wompi.setMonto(payment.getMonto());
		
		//Obtener el  usuario para los  datos  de  email y  nombre
		user usuario = usuarioRepo.findById(payment.getIdUsuario()).orElseThrow(()-> new NotFoundException("No se encontro el usuario"));
		wompi.setEmailCliente(usuario.getEmail());
		wompi.setNombreCliente(usuario.getUserName());
		ConfigurationWompiDto config = new ConfigurationWompiDto();
		config.setNotificarTransaccionCliente(false);
		wompi.setConfiguracion(config);
		
		List<tokenPayment> tokenEnt = tokenRepo.findAll();
		String token = "";
		if(tokenEnt.isEmpty()) {
			token  = generateTokenPayment(0l);
		}else {
			token = tokenEnt.get(0).getAccessToken();
		}

		
		
		//Seteo de token
		HttpHeaders headers = new HttpHeaders();
		headers.setBearerAuth(token);
		
		HttpEntity<RequestWompi> entity = new HttpEntity<>(wompi, headers);
		ResponseEntity<String> response = null;
		//Ejecucion d e la peticion de la pasarela depago
		try {
			 response = restTemplate.postForEntity(fooResourceUrl,entity, String.class);
		}catch (Exception e) {
			generateTokenPayment(tokenEnt.get(0).getIdToken());
			payment(payment);
		}

		System.out.println("RESPONSE SOUP "+ response.toString());
		return "Pago realizado con exito";
	}
	
	
	/**
	 * Generacion de token para pasarela de pago
	 * @return token  
	 */
	private String generateTokenPayment(Long idToken) {
		RestTemplate restTemplate = new RestTemplate();
		String token = "https://id.wompi.sv/connect/token";
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		
		//Construccion del body  de la peticion del token
		MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
		map.add("grant_type", "client_credentials");
		map.add("client_id", "00e082a7-6be6-426c-b8a4-8f0b9e086505");
		map.add("client_secret", "d27c596c-c8c4-48da-a193-3929330d1b87");
		map.add("audience", "wompi_api");

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

		ResponseEntity<String> response = restTemplate.postForEntity( token, request , String.class );
		System.out.println(response.getBody().toString());
		if(response.getStatusCode() == HttpStatus.OK) {
			JsonObject objectjson = new JsonParser().parse(response.getBody()).getAsJsonObject();
			ResponseTokenWompi tokenWompi = new Gson().fromJson(objectjson, ResponseTokenWompi.class);
			tokenPayment tokenEnt = new tokenPayment();
			
			if(!idToken.equals(0l)) {
				tokenEnt.setIdToken(idToken);
			}
			tokenEnt.setAccessToken(tokenWompi.getAccess_token());
			tokenEnt.setExpires(tokenWompi.getExpires_in());
			tokenRepo.save(tokenEnt);
			return tokenWompi.getAccess_token();
		}

		return  "";
	}
	
	

}
