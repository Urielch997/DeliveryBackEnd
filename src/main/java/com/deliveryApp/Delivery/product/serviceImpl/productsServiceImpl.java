package com.deliveryApp.Delivery.product.serviceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.deliveryApp.Delivery.product.model.products;
import com.deliveryApp.Delivery.product.repository.productsRepository;
import com.deliveryApp.Delivery.product.responseDto.ProductoResponseDto;
import com.deliveryApp.Delivery.product.service.productsService;
import com.deliveryApp.Delivery.user.model.favoritos;
import com.deliveryApp.Delivery.user.repository.FavoritosUserRepository;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
@Transactional
public class productsServiceImpl implements productsService{


	@Autowired 
	public productsRepository productRepository;
	
	@Autowired
	public FavoritosUserRepository favRepository;
	
	@Override
	public Page<ProductoResponseDto> getAllProducts(Long idUser,int page, int size) {
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		Page<ProductoResponseDto> producto = productRepository.findAll(PageRequest.of(page, size,Sort.by("IdItem").ascending())).map(x->{
			ProductoResponseDto productRes = new ProductoResponseDto();
			productRes = mapper.convertValue(x, ProductoResponseDto.class);
			if(idUser != null) {
			favoritos fav = favRepository.findByUsuarioIdUserAndProductoIdItem(idUser,x.getIdItem());
			if(fav != null) {
				productRes.setFavorito(true);
			}else {
				productRes.setFavorito(false);
			}
			}else {
				productRes.setFavorito(false);
			}
			
			return productRes;
		});
		
		return producto;
	}

}
