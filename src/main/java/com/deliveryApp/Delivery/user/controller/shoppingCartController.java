package com.deliveryApp.Delivery.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deliveryApp.Delivery.reddis.shopingCart.entity.Item;
import com.deliveryApp.Delivery.reddis.shopingCart.service.ShoppingCartService;
import com.deliveryApp.Delivery.utils.ServiceResponse;
import com.deliveryApp.Delivery.utils.ServiceResponseFactory;

@RestController
@RequestMapping("/shoppingCart")
public class shoppingCartController {
	
	@Autowired
	ShoppingCartService shopingservice;
	
	@GetMapping("/countCart/{idCart}")
	public ResponseEntity<ServiceResponse> getCuantityCart(@PathVariable(name = "idCart") String idCart){
		return ServiceResponseFactory.createResponse(shopingservice.countCart(idCart));
	}

	
	@DeleteMapping
	public ResponseEntity<ServiceResponse> deleteCart(){
		return null;
	}
	
	@PostMapping("/addShoppingCart")
	public ResponseEntity<ServiceResponse> addShoppingCart(@RequestBody Item product){
		return ServiceResponseFactory.createResponse(shopingservice.addShoppingCart(product));
	}
	
	@GetMapping("/getCart/{idCart}")
	public ResponseEntity<ServiceResponse> getCart(@PathVariable(name = "idCart") String idCart){
		return ServiceResponseFactory.createResponse(shopingservice.getCart(idCart));
	}
}
