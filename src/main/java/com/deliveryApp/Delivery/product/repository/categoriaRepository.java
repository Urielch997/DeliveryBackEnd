package com.deliveryApp.Delivery.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deliveryApp.Delivery.product.model.Categoria;

public interface categoriaRepository extends  JpaRepository<Categoria, Long>{

}
