package com.deliveryApp.Delivery.reddis.shopingCart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deliveryApp.Delivery.reddis.shopingCart.entity.Item;


public interface ShoppingRepository extends JpaRepository<Item, String> {
	List<Item> findByIdUser(String idUser);

	Item  existsByProducts(String idItem);
}
