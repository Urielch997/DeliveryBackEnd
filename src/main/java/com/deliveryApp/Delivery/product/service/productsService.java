package com.deliveryApp.Delivery.product.service;

import org.springframework.data.domain.Page;

import com.deliveryApp.Delivery.product.model.products;
import com.deliveryApp.Delivery.product.responseDto.ProductoResponseDto;

public interface productsService{
	
	
	public Page<ProductoResponseDto> getAllProducts(Long idUser,int page,int size);

}
