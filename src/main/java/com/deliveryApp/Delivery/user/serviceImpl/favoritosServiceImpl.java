package com.deliveryApp.Delivery.user.serviceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.deliveryApp.Delivery.exception.NotFoundException;
import com.deliveryApp.Delivery.product.model.products;
import com.deliveryApp.Delivery.product.repository.productsRepository;
import com.deliveryApp.Delivery.product.responseDto.ProductoResponseDto;
import com.deliveryApp.Delivery.user.model.favoritos;
import com.deliveryApp.Delivery.user.model.user;
import com.deliveryApp.Delivery.user.repository.FavoritosUserRepository;
import com.deliveryApp.Delivery.user.repository.UsuarioRepository;
import com.deliveryApp.Delivery.user.requestDto.FavoritoSaveRequestdto;
import com.deliveryApp.Delivery.user.responseDto.favoritosUserResponse;
import com.deliveryApp.Delivery.user.service.favoritosUserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Transactional
public class favoritosServiceImpl implements favoritosUserService{
	
	@Autowired
	public FavoritosUserRepository favRepository;
	
	@Autowired 
	public productsRepository prodRepo;
	
	@Autowired 
	public UsuarioRepository usuRepo;
	
	@Autowired
	ObjectMapper mapper;


	@Override
	public Page<favoritosUserResponse> getFavoritosByUser(Long id,int page,int size) {
		Page<favoritosUserResponse> fav = favRepository.getByUsuarioIdUser(id,PageRequest.of(page, size)).map(x->{
			favoritosUserResponse favDto = new favoritosUserResponse();
			ProductoResponseDto product = mapper.convertValue(x.getProducto(), ProductoResponseDto.class);
			product.setFavorito(true);
			favDto = mapper.convertValue(x, favoritosUserResponse.class);
			favDto.setProducto(product);
			return favDto;
		});
		return fav;
	}

	@Override
	public String guardarFavorito(FavoritoSaveRequestdto favorito) {
		favoritos fav = new favoritos();
		products producto = prodRepo.findById(favorito.getIdProducto()).orElseThrow(()-> new NotFoundException("No se enconrto el producto"));
		user usuario = usuRepo.findById(favorito.getIdUser()).orElseThrow(()-> new NotFoundException("No se enconrto el usuario"));
		fav.setProducto(producto);
		fav.setUsuario(usuario);
		favRepository.save(fav);
		return "Guardado";
	}

	@Override
	public String deleteFavorito(Long idFavorito) {
		favoritos fav = favRepository.findById(idFavorito).orElseThrow(()-> new NotFoundException("No se encontro registro"));
		favRepository.delete(fav);
		return "Eliminado";
	}
	
	@Override
	public String deleteFavoritoUsuarioAndProducto(Long idUsuario,Long idProducto) {
		favoritos fav = favRepository.findByUsuarioIdUserAndProductoIdItem(idUsuario,idProducto);
		favRepository.delete(fav);
		return "Eliminado";
	}
	
	
	
	
}
