package com.deliveryApp.Delivery.reddis.shopingCart.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("ItemProduct")
public class ItemProduct implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	private String idItem;
	
	private String nombre;
	
	private Long idCategoria;
	
	private Double precio;
	
	private Double precioOferta;
	
	private String imagen;
	
	private String description;

	public String getIdItem() {
		return idItem;
	}

	public void setIdItem(String idItem) {
		this.idItem = idItem;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Double getPrecioOferta() {
		return precioOferta;
	}

	public void setPrecioOferta(Double precioOferta) {
		this.precioOferta = precioOferta;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
