package com.deliveryApp.Delivery.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deliveryApp.Delivery.payment.model.tokenPayment;

public interface tokenPayRepository extends JpaRepository<tokenPayment, Long> {

}
