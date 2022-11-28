package com.deliveryApp.Delivery.reddis.shopingCart.dto;

import java.util.List;

import com.deliveryApp.Delivery.reddis.shopingCart.entity.ItemProduct;

public class CartDto {

	private String idCart;

	private String idUser;
	
	private List<ItemProduct> products;
	
	private Integer count;

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

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
	
	
	
}
