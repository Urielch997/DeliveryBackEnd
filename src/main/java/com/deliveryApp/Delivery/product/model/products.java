package com.deliveryApp.Delivery.product.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "item", schema = "productos")
public class products {

	@Column(name = "id_item")
	@Id
	private Long idItem;
	
	private String nombre;
	
	@Column(name = "id_categoria")
	private Long idCategoria;
	
	private Float precio;
	
	@Column(name = "precio_oferta")
	private Float precioOferta;
	
	private String picture;

	public Long getIdItem() {
		return idItem;
	}

	public void setIdItem(Long idItem) {
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

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public Float getPrecioOferta() {
		return precioOferta;
	}

	public void setPrecioOferta(Float precioOferta) {
		this.precioOferta = precioOferta;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	
	
	
	
}
