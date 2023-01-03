package com.deliveryApp.Delivery.product.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.deliveryApp.Delivery.product.responseDto.CateogiraDto;
import com.deliveryApp.Delivery.product.responseDto.ProductoResponseDto;

public interface productsService{
	
	
	public Page<ProductoResponseDto> getAllProducts(Long idUser,int page,int size);


	public List<CateogiraDto> getAllCategorias();
}
