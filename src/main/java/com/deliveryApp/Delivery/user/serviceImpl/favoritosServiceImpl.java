package com.deliveryApp.Delivery.user.serviceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.deliveryApp.Delivery.user.model.favoritos;
import com.deliveryApp.Delivery.user.repository.FavoritosUserRepository;
import com.deliveryApp.Delivery.user.service.favoritosUserService;

@Service
@Transactional
public class favoritosServiceImpl implements favoritosUserService{
	
	@Autowired
	public FavoritosUserRepository favRepository;

	@Override
	public Page<favoritos> getFavoritosByUser(Long id,int page,int size) {
		System.out.println("Favorito " + id + page + size);
		Page<favoritos> fav = favRepository.getByUsuarioIdUser(id,PageRequest.of(page, size));		
		System.out.println( "Fav string " +  fav.toString());
		return fav;
	}
	
}
