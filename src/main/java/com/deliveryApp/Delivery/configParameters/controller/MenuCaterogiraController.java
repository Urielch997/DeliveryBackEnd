package com.deliveryApp.Delivery.configParameters.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.deliveryApp.Delivery.utils.ServiceResponse;

@RestController
@RequestMapping("/config")
public class MenuCaterogiraController {
	
	@GetMapping("/menu-categoria")
	public ResponseEntity<ServiceResponse> getMenuCategory(@RequestParam(name = "page") int page,
			@RequestParam(name = "size") int size){
		return null;
	}
}
