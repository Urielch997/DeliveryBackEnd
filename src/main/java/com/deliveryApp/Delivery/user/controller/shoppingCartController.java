package com.deliveryApp.Delivery.user.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deliveryApp.Delivery.utils.ServiceResponse;

@RestController
@RequestMapping("/shoppingCart")
public class shoppingCartController {
	
	@GetMapping("/countCart")
	public ResponseEntity<ServiceResponse> getCuantityCart(){
		return null;
	}
	
	@GetMapping("/getListProductByUser")
	public ResponseEntity<ServiceResponse> getListProductByUser(){
		return null;
	}
	
	@DeleteMapping
	public ResponseEntity<ServiceResponse> deleteCart(){
		return null;
	}
	
	@PostMapping("/addShoppingCart")
	public ResponseEntity<ServiceResponse> addShoppingCart(){
		return null;
	}
}
