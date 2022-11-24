package com.deliveryApp.Delivery.reddis.shopingCart.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deliveryApp.Delivery.exception.NotFoundException;
import com.deliveryApp.Delivery.reddis.shopingCart.entity.Item;
import com.deliveryApp.Delivery.reddis.shopingCart.repository.ShoppingRepository;
import com.deliveryApp.Delivery.reddis.shopingCart.service.ShoppingCartService;

@Service
public class ShopingCartServiceImpl implements ShoppingCartService{
	
	@Autowired
	ShoppingRepository shopingRepo;

	@Override
	public String addShoppingCart(Item product) {
		Item userAdd = shopingRepo.save(product);
		System.out.println(userAdd.toString());
		return userAdd.getIdCart();
	}

	@Override
	public Item getShoopingCart(String idUser) {
		Item userAdd =  shopingRepo.findByIdUser(idUser);
		System.out.println(userAdd.toString());
		return userAdd;
	}

	@Override
	public Item getCart(String idCart) {
		return shopingRepo.findById(idCart).orElseThrow(()-> new NotFoundException("No se encontro carrito"));
	}

	@Override
	public Integer countCart(String idCart) {
		return shopingRepo.findById(idCart).get().getProducts().size();
	}

}
