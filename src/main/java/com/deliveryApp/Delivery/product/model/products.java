package com.deliveryApp.Delivery.product.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "item", schema = "productos")
public class products implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "id_item")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long idItem;
	
	private String nombre;
	
	@Column(name = "id_categoria")
	private Long idCategoria;
	
	private Float precio;
	
	@Column(name = "precio_oferta")
	private Float precioOferta;
	
	private String imagen;
	
	private String description;

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

	@Override
	public String toString() {
		return "products [idItem=" + idItem + ", nombre=" + nombre + ", idCategoria=" + idCategoria + ", precio="
				+ precio + ", precioOferta=" + precioOferta + ", imagen=" + imagen + "]";
	}
	
	
	
	
	
	
	
}
