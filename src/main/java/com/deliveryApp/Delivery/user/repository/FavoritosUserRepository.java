package com.deliveryApp.Delivery.user.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.deliveryApp.Delivery.user.model.favoritos;
import com.deliveryApp.Delivery.user.model.pKCom.PKFav;

public interface FavoritosUserRepository extends JpaRepository<favoritos, PKFav>{
	Page<favoritos>  findByUsuarioIdUser(Long  item,Pageable page);
}
