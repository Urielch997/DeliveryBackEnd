package com.deliveryApp.Delivery.reddis.shopingCart.service;

import com.deliveryApp.Delivery.reddis.shopingCart.entity.Item;

public interface ShoppingCartService {
	String addShoppingCart(Item product);
	
	Item getShoopingCart(String idUser);
	
	Item getCart(String idCart);
	
	Integer countCart(String idCart);
}
