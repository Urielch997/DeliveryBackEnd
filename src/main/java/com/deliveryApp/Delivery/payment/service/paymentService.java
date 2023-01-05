package com.deliveryApp.Delivery.payment.service;

import com.deliveryApp.Delivery.payment.dto.RequestPayment;

public interface paymentService {
	String payment(RequestPayment payment);
}
