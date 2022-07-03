package com.deliveryApp.Delivery.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.deliveryApp.Delivery.product.service.productsService;
import com.deliveryApp.Delivery.utils.ServiceResponse;
import com.deliveryApp.Delivery.utils.ServiceResponseFactory;


@RestController
@RequestMapping("/products")
public class productsController {
	
	
	@Autowired
	private productsService product;
	
	
	@GetMapping
	public ResponseEntity<ServiceResponse> getAllProducto(@RequestParam(name = "idUser")Long idUser, @RequestParam(name = "page",defaultValue = "0")int page,
			@RequestParam(name = "size", defaultValue = "10")int size) {
		return ServiceResponseFactory.createResponse(product.getAllProducts(idUser,page,size));
	}

}
