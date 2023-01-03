package com.deliveryApp.Delivery.user.serviceImpl;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.deliveryApp.Delivery.exception.NotFoundException;
import com.deliveryApp.Delivery.product.model.products;
import com.deliveryApp.Delivery.product.repository.productsRepository;
import com.deliveryApp.Delivery.user.model.favoritos;
import com.deliveryApp.Delivery.user.model.user;
import com.deliveryApp.Delivery.user.model.pKCom.PKFav;
import com.deliveryApp.Delivery.user.repository.FavoritosUserRepository;
import com.deliveryApp.Delivery.user.repository.UsuarioRepository;
import com.deliveryApp.Delivery.user.requestDto.FavoritoSaveRequestdto;
import com.deliveryApp.Delivery.user.responseDto.favoritosUserResponse;
import com.deliveryApp.Delivery.user.service.favoritosUserService;

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
	ModelMapper mapper;


	@Override
	public Page<favoritosUserResponse> getFavoritosByUser(Long id,int page,int size) {
		Page<favoritosUserResponse> fav = favRepository.findByUsuarioIdUser(id,PageRequest.of(page, size)).map(x-> {
			favoritosUserResponse favMap = mapper.map(x, favoritosUserResponse.class);
			favMap.getProducto().setFavorito(true);
			return  favMap;
		});
		return fav;
	}

	@Override
	public String guardarFavorito(FavoritoSaveRequestdto favorito) {
		favoritos fav = new favoritos();
		products producto = prodRepo.findById(favorito.getIdProducto()).orElseThrow(()-> new NotFoundException("No se enconrto el producto"));
		user usuario = usuRepo.findById(favorito.getIdUser()).orElseThrow(()-> new NotFoundException("No se enconrto el usuario"));
		fav.setProducto(producto);
		System.out.println("PRRODUCTO "+ producto.toString());
		fav.setUsuario(usuario);
		System.out.println("==USUARIO" +  usuario.toString());
		fav.setIdItem(favorito.getIdProducto());
		fav.setIdUser(favorito.getIdUser());
		System.out.println("===FAV  "+ fav.toString());
		favRepository.save(fav);
		return "Guardado";
	}

	@Override
	public String deleteFavorito(Long idItem,Long idUser) {
		PKFav pkfav = new PKFav();
		pkfav.setIdItem(idItem);
		pkfav.setIdUser(idUser);
		favoritos fav = favRepository.findById(pkfav).orElseThrow(()-> new NotFoundException("No se encontro registro"));
		favRepository.delete(fav);
		return "Eliminado";
	}
	
	@Override
	public String deleteFavoritoUsuarioAndProducto(Long idUsuario,Long idProducto) {
		PKFav pkfav = new PKFav();
		pkfav.setIdItem(idProducto);
		pkfav.setIdUser(idUsuario);
		favoritos fav = favRepository.findById(pkfav).orElseThrow(()-> new NotFoundException("No se encontro registro"));
		favRepository.delete(fav);
		return "Eliminado";
	}
	
	
	
	
}
