package com.deliveryApp.Delivery.product.responseDto;

public class ProductoResponseDto {
	private Long idItem;
	private String nombre;
	private Long idCategoria;
	private Float precio;
	private Float precioOferta;
	private String imagen;
	private String description;
	private boolean favorito;
	

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

	public boolean isFavorito() {
		return favorito;
	}

	public void setFavorito(boolean favorito) {
		this.favorito = favorito;
	}

	@Override
	public String toString() {
		return "ProductoResponseDto [idItem=" + idItem + ", nombre=" + nombre + ", idCategoria=" + idCategoria
				+ ", precio=" + precio + ", precioOferta=" + precioOferta + ", imagen=" + imagen + ", description="
				+ description + ", favorito=" + favorito + "]";
	}
	
	
}