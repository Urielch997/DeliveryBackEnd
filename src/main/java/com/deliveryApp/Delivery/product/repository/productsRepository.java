package com.deliveryApp.Delivery.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deliveryApp.Delivery.product.model.products;

public interface productsRepository extends JpaRepository<products, Long>{

}
