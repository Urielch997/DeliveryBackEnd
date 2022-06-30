package com.deliveryApp.Delivery.user.service;

import org.springframework.data.domain.Page;

import com.deliveryApp.Delivery.user.model.favoritos;

public interface favoritosUserService {
	public Page<favoritos> getFavoritosByUser(Long id,int page,int size);
}
