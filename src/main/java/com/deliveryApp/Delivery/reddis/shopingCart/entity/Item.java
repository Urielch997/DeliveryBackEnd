package com.deliveryApp.Delivery.reddis.shopingCart.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@RedisHash("Item")
public class Item implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String idCart;

	 @Indexed
	private String idUser;
	
	 @Indexed
	private ItemProduct products;
	
	public ItemProduct getProducts() {
		return products;
	}

	public void setProducts(ItemProduct products) {
		this.products = products;
	}

	public String getIdCart() {
		return idCart;
	}

	public void setIdCart(String idCart) {
		this.idCart = idCart;
	}

	public String getIdUser() {
		return idUser;
	}
	
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	@Override
	public String toString() {
		return "Item [idItem=" + idCart + ", idUser=" + idUser + ", products=" + products + "]";
	}
	
	
	
	
}
