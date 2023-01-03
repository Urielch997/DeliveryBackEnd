package com.deliveryApp.Delivery.product.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categoria",schema = "productos")
public class Categoria {
	@Id
	@Column(name ="id_categoria")
	private Long idCategoria;
	
	@Column(name =  "nombre_categoria")
	private String nombreCategoria;
	
	private  String descripcion;

	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNombreCategoria() {
		return nombreCategoria;
	}

	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Categoria [idCategoria=" + idCategoria + ", nombreCategoria=" + nombreCategoria + ", descripcion="
				+ descripcion + "]";
	}
	
	
}
