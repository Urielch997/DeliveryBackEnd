package com.deliveryApp.Delivery.configParameters.service;

import com.deliveryApp.Delivery.configParameters.Dto.CategoriasDto;
import com.deliveryApp.Delivery.configParameters.model.Categorias;

import java.util.List;

public interface CategoriaService {

    public List<Categorias> listCategorias();

    public Categorias createCategoria(CategoriasDto dto);

    public Categorias updateCategorria(CategoriasDto dto);

    public String deleteCategoria(Long id);

}
