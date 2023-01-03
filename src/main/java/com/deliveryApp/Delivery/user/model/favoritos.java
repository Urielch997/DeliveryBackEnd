package com.deliveryApp.Delivery.user.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.deliveryApp.Delivery.product.model.products;
import com.deliveryApp.Delivery.user.model.pKCom.PKFav;


@Entity
@Table(name = "favoritos_user", schema = "usuario" )
@IdClass(PKFav.class)
public class favoritos implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name  = "id_producto")
	private Long  idItem;
	
	@Id
	@Column(name =  "id_user")
	private Long idUser;
		

	@JoinColumn(name = "id_producto",referencedColumnName = "id_item",insertable = false,updatable = false)
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	private products producto;
	

	@JoinColumn(name = "id_user", referencedColumnName = "id_user",insertable = false,updatable = false)
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	private user usuario;

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


	public Long getIdItem() {
		return idItem;
	}

	public void setIdItem(Long idItem) {
		this.idItem = idItem;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	@Override
	public String toString() {
		return "favoritos [idItem=" + idItem + ", idUser=" + idUser + ", producto=" + producto + ", usuario=" + usuario
				+ "]";
	}

	
	
}
