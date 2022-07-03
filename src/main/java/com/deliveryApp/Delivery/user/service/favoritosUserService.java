package com.deliveryApp.Delivery.user.service;

import org.springframework.data.domain.Page;

import com.deliveryApp.Delivery.user.model.favoritos;
import com.deliveryApp.Delivery.user.requestDto.FavoritoSaveRequestdto;

public interface favoritosUserService {
	public Page<favoritos> getFavoritosByUser(Long id,int page,int size);
	
	public String guardarFavorito(FavoritoSaveRequestdto favorito);
}
