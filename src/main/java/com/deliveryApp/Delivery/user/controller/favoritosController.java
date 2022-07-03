package com.deliveryApp.Delivery.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.deliveryApp.Delivery.user.requestDto.FavoritoSaveRequestdto;
import com.deliveryApp.Delivery.user.service.favoritosUserService;
import com.deliveryApp.Delivery.utils.ServiceResponse;
import com.deliveryApp.Delivery.utils.ServiceResponseFactory;

@RestController
@RequestMapping("/User")
public class favoritosController {
	
	@Autowired
	private favoritosUserService favoritos;
	
	@GetMapping("/favoritos")
	public ResponseEntity<ServiceResponse> getMenuCategory(@RequestParam(name = "idUser") Long idUser, @RequestParam(name = "page") int page,
			@RequestParam(name = "size") int size){
		return ServiceResponseFactory.createResponse(favoritos.getFavoritosByUser(idUser, page, size));
	}
	
	@PostMapping("/favoritos")
	public ResponseEntity<ServiceResponse> guardarFavorito(@RequestBody FavoritoSaveRequestdto favorito){
		return ServiceResponseFactory.createResponse(favoritos.guardarFavorito(favorito));
	}

}
