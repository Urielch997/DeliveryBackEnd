package com.deliveryApp.Delivery.user.service;

import org.springframework.data.domain.Page;

import com.deliveryApp.Delivery.user.requestDto.FavoritoSaveRequestdto;
import com.deliveryApp.Delivery.user.responseDto.favoritosUserResponse;

public interface favoritosUserService {
	public Page<favoritosUserResponse> getFavoritosByUser(Long id,int page,int size);
	
	public String guardarFavorito(FavoritoSaveRequestdto favorito);
	
	public String deleteFavorito(Long idFavorito);
}
