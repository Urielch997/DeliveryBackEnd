package com.deliveryApp.Delivery.user.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.deliveryApp.Delivery.user.model.favoritos;

public interface FavoritosUserRepository extends JpaRepository<favoritos, Long>{

	Page<favoritos> getByUsuarioIdUser(Long id,Pageable pegeable);
}
