package com.deliveryApp.Delivery.user.responseDto;

import com.deliveryApp.Delivery.product.responseDto.ProductoResponseDto;
import com.deliveryApp.Delivery.user.model.user;
import com.fasterxml.jackson.annotation.JsonProperty;

public class favoritosUserResponse {
	private Long idFavorito;
	private ProductoResponseDto producto;
	private user usuario;
	
	public Long getIdFavorito() {
		return idFavorito;
	}
	public void setIdFavorito(Long idFavorito) {
		this.idFavorito = idFavorito;
	}
	public ProductoResponseDto getProducto() {
		return producto;
	}
	public void setProducto(ProductoResponseDto producto) {
		this.producto = producto;
	}
	public user getUsuario() {
		return usuario;
	}
	public void setUsuario(user usuario) {
		this.usuario = usuario;
	}
	
}


