package com.deliveryApp.Delivery.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	
	@DeleteMapping
	public ResponseEntity<ServiceResponse> deleteCart(){
		return null;
	}
	
	@PostMapping("/addShoppingCart")
	public ResponseEntity<ServiceResponse> addShoppingCart(@RequestBody Item product){
		return ServiceResponseFactory.createResponse(shopingservice.addShoppingCart(product));
	}
	
	@GetMapping("/getCart/{idUser}")
	public ResponseEntity<ServiceResponse> getCart(@PathVariable(name = "idUser") String idUser){
		return ServiceResponseFactory.createResponse(shopingservice.getShoopingCart(idUser));
	}
	
	@DeleteMapping("delete/{idUser}")
	public ResponseEntity<ServiceResponse> deleteCart(@PathVariable(name = "idUser") String idUser,@RequestParam("idItem") String idItem){
		return ServiceResponseFactory.createResponse(shopingservice.deleteItem(idItem,idUser));
	}
}
