package com.deliveryApp.Delivery.user.model;

import java.io.Serializable;

import javax.persistence.Column;
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
@Table(name = "favoritos_user", schema = "usuario" )
public class favoritos implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_favorito")
	private Long idFavorito;
	
	@JoinColumn(name = "id_producto",referencedColumnName = "id_item")
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	private products producto;
	
	@JoinColumn(name = "id_user", referencedColumnName = "id_user")
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	private user usuario;

	public Long getIdFavorito() {
		return idFavorito;
	}

	public void setIdFavorito(Long idFavorito) {
		this.idFavorito = idFavorito;
	}

	public products getProducto() {
		return producto;
	}

	public void setProducto(products producto) {
		this.producto = producto;
	}

	public user getUsuario() {
		return usuario;
	}

	public void setUsuario(user usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "favoritos [idFavorito=" + idFavorito +", usuario=" + usuario + "]";
	}
	
	
	
	
}
