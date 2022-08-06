package com.deliveryApp.Delivery.configParameters.service.Impl;

import com.deliveryApp.Delivery.configParameters.Dto.CategoriasDto;
import com.deliveryApp.Delivery.configParameters.model.Categorias;
import com.deliveryApp.Delivery.configParameters.repository.CategoriasRepository;
import com.deliveryApp.Delivery.configParameters.service.CategoriaService;
import com.deliveryApp.Delivery.exception.CustomException;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class CategoriaSeviceImpl implements CategoriaService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CategoriasRepository categoriasRepository;

    @Override
    public List<Categorias> listCategorias() {
        try {
            return categoriasRepository.findAll();
        }catch (Exception e){
            log.info("A expeted error: " + e.getMessage());
            throw  new CustomException("A expeted error: " + e.getMessage());
        }
    }

    @Override
    public Categorias createCategoria(CategoriasDto dto) {
        return null;
    }

    @Override
    public Categorias updateCategorria(CategoriasDto dto) {
        return null;
    }

    @Override
    public String deleteCategoria(Long id) {
        return null;
    }
}
