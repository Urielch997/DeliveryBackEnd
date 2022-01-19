package com.deliveryApp.Delivery.product.service;

import org.springframework.data.domain.Page;

import com.deliveryApp.Delivery.product.model.products;

public interface productsService{
	
	
	public Page<products> getAllProducts(int page,int size);

}
