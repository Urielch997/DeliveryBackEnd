package com.deliveryApp.Delivery.reddis.shopingCart.entity;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("Item")
public class Item implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String idCart;

	private String idUser;
	
	private List<ItemProduct> products;
	
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

	public List<ItemProduct> getProducts() {
		return products;
	}

	public void setProducts(List<ItemProduct> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Item [idItem=" + idCart + ", idUser=" + idUser + ", products=" + products + "]";
	}
	
	
	
	
}
