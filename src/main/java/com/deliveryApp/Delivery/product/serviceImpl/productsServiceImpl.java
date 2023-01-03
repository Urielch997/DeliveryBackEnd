package com.deliveryApp.Delivery.product.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.deliveryApp.Delivery.product.repository.categoriaRepository;
import com.deliveryApp.Delivery.product.repository.productsRepository;
import com.deliveryApp.Delivery.product.responseDto.CateogiraDto;
import com.deliveryApp.Delivery.product.responseDto.ProductoResponseDto;
import com.deliveryApp.Delivery.product.service.productsService;
import com.deliveryApp.Delivery.user.model.pKCom.PKFav;
import com.deliveryApp.Delivery.user.repository.FavoritosUserRepository;


@Service
@Transactional
public class productsServiceImpl implements productsService{


	@Autowired 
	public productsRepository productRepository;
	
	@Autowired
	private categoriaRepository categoRepo;
	
	@Autowired
	public FavoritosUserRepository favRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public Page<ProductoResponseDto> getAllProducts(Long idUser,int page, int size) {
		Page<ProductoResponseDto>  response = productRepository.findAll(PageRequest.of(page, size)).map(x-> {
			ProductoResponseDto mapeo =	mapper.map(x, ProductoResponseDto.class);
			PKFav pkfav = new  PKFav();
			pkfav.setIdUser(idUser);
			pkfav.setIdItem(x.getIdItem());
			mapeo.setFavorito(favRepository.existsById(pkfav));
			return mapeo;
		});
		return response;
	}

	@Override
	public List<CateogiraDto> getAllCategorias() {
		return categoRepo.findAll().stream().map(x->mapper.map(x, CateogiraDto.class)).collect(Collectors.toList());
	}

}
