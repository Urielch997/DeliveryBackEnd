package com.deliveryApp.Delivery.reddis.shopingCart.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deliveryApp.Delivery.exception.CustomException;
import com.deliveryApp.Delivery.exception.NotFoundException;
import com.deliveryApp.Delivery.reddis.shopingCart.dto.CartDto;
import com.deliveryApp.Delivery.reddis.shopingCart.entity.Item;
import com.deliveryApp.Delivery.reddis.shopingCart.entity.ItemProduct;
import com.deliveryApp.Delivery.reddis.shopingCart.repository.ShoppingRepository;
import com.deliveryApp.Delivery.reddis.shopingCart.service.ShoppingCartService;

@Service
public class ShopingCartServiceImpl implements ShoppingCartService{
	
	@Autowired
	ShoppingRepository shopingRepo;

	@Override
	public String addShoppingCart(Item product) {
	
			List<Item> cartExist = shopingRepo.findByIdUser(product.getIdUser());
			cartExist.stream().forEach(cards -> { 
				if(cards.getProducts().getIdItem().equals(product.getProducts().getIdItem())) {
					throw new CustomException("Articulo  ya se encuentra en el carrito");
				}
			});
		Item userAdd = shopingRepo.save(product);
		return userAdd.getIdCart();
	}

	@Override
	public CartDto getShoopingCart(String idUser) {
		List<Item> userAdd =  shopingRepo.findByIdUser(idUser);
		CartDto card = new CartDto();
		card.setIdUser(idUser);
		card.setIdCart(userAdd.get(0).getIdCart());
		card.setCount(userAdd.size());
		List<ItemProduct> productItem = new ArrayList<>();
		userAdd.stream().forEach( cards -> {
			productItem.add(cards.getProducts());	
		});
		card.setProducts(productItem);
		return card;
	}

	@Override
	public String deleteItem(String idItem,String idUser) {
		List<Item> userAdd =  shopingRepo.findByIdUser(idUser);
		if(userAdd.size() == 0) {
			throw new NotFoundException("No existe carrito de compras para este usuario");
		}
		
		userAdd.forEach(ele  -> {
			if(ele.getProducts().getIdItem().equals(idItem)) {
				shopingRepo.deleteById(ele.getIdCart());
			}
		});
		
		return "Registro eliminado";
		
	}





}
