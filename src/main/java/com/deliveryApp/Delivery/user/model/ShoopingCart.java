package com.deliveryApp.Delivery.user.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.deliveryApp.Delivery.product.model.products;

@Entity
@Table(name = "shopping_cart", schema = "usuario")
public class ShoopingCart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idShopping;
	
	@JoinColumn(name = "id_user",referencedColumnName = "id_user")
	@ManyToOne(fetch = FetchType.LAZY)
	private user usuario;
	
	@JoinColumn(name = "id_product",referencedColumnName = "id_item")
	@ManyToOne(fetch = FetchType.LAZY)
	private products productos;

	public Long getIdShopping() {
		return idShopping;
	}

	public void setIdShopping(Long idShopping) {
		this.idShopping = idShopping;
	}

	public user getUsuario() {
		return usuario;
	}

	public void setUsuario(user usuario) {
		this.usuario = usuario;
	}

	public products getProductos() {
		return productos;
	}

	public void setProductos(products productos) {
		this.productos = productos;
	}
	
	
}
