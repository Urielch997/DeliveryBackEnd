package com.deliveryApp.Delivery.reddis.shopingCart.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.deliveryApp.Delivery.reddis.shopingCart.entity.Item;


@Repository
public interface ShoppingRepository extends CrudRepository<Item, String> {
	Item findByIdUser(String idUser);
}
