package com.deliveryApp.Delivery.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deliveryApp.Delivery.user.model.ShoopingCart;

public interface ShoppingRepository extends JpaRepository<ShoopingCart, Long>{

}
