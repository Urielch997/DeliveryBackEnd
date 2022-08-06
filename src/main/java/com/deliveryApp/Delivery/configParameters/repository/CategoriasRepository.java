package com.deliveryApp.Delivery.configParameters.repository;

import com.deliveryApp.Delivery.configParameters.model.Categorias;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriasRepository extends JpaRepository<Categorias,Long> {
}
