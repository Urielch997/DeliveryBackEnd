package com.deliveryApp.Delivery.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.deliveryApp.Delivery.payment.dto.RequestPayment;
import com.deliveryApp.Delivery.payment.service.paymentService;
import com.deliveryApp.Delivery.utils.ServiceResponse;
import com.deliveryApp.Delivery.utils.ServiceResponseFactory;

@RestController
public class paymentController {
	
	@Autowired
	private paymentService servicePay;
	
	@PostMapping("/pay")
	public ResponseEntity<ServiceResponse> payment(@RequestBody RequestPayment payment) {
		return ServiceResponseFactory.createResponse(servicePay.payment(payment));
	}

}
