package com.deliveryApp.Delivery.product.serviceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.deliveryApp.Delivery.product.model.products;
import com.deliveryApp.Delivery.product.repository.productsRepository;
import com.deliveryApp.Delivery.product.service.productsService;


@Service
@Transactional
public class productsServiceImpl implements productsService{


	@Autowired 
	public productsRepository productRepository;
	
	public Page<products> getAllProducts(int page, int size) {
		
		return productRepository.findAll(PageRequest.of(page, size));
	}

}
