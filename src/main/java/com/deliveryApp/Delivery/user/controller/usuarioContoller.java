package com.deliveryApp.Delivery.user.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.deliveryApp.Delivery.user.requestDto.UsuarioInfoRequestDto;
import com.deliveryApp.Delivery.user.service.UsuarioService;
import com.deliveryApp.Delivery.utils.ServiceResponse;
import com.deliveryApp.Delivery.utils.ServiceResponseFactory;

@RestController
@RequestMapping("/usuario")
public class usuarioContoller {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PutMapping
	public ResponseEntity<ServiceResponse> actualizarInfo(@RequestBody UsuarioInfoRequestDto userinfo){
		return ServiceResponseFactory.createResponse(usuarioService.UpdateInfoUser(userinfo));
	}
	
	@GetMapping
	public ResponseEntity<ServiceResponse> getShoppingCart(@RequestParam(name = "idUser") Long idUser){
		return null;
	}

}
