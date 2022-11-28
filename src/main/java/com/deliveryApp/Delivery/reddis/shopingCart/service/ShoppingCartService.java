package com.deliveryApp.Delivery.reddis.shopingCart.service;

import com.deliveryApp.Delivery.reddis.shopingCart.dto.CartDto;
import com.deliveryApp.Delivery.reddis.shopingCart.entity.Item;

public interface ShoppingCartService {
	String addShoppingCart(Item product);
	
	CartDto getShoopingCart(String idUser);
	
	String deleteItem(String idItem,String idUser);
	
}
