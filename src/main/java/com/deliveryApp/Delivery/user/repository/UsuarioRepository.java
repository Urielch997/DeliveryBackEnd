package com.deliveryApp.Delivery.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deliveryApp.Delivery.user.model.user;

public interface UsuarioRepository extends JpaRepository<user, Long>{
    Optional<user> findByEmail(String email);

    Boolean existsByEmail(String email);
}
