package com.deliveryApp.Delivery.configParameters.service.Impl;

import com.deliveryApp.Delivery.configParameters.Dto.CategoriasDto;
import com.deliveryApp.Delivery.configParameters.Enums.Status;
import com.deliveryApp.Delivery.configParameters.model.Categorias;
import com.deliveryApp.Delivery.configParameters.repository.CategoriasRepository;
import com.deliveryApp.Delivery.configParameters.service.CategoriaService;
import com.deliveryApp.Delivery.exception.CustomException;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

        try {
            Date date = new Date();
            Categorias categorias = modelMapper.map(dto,Categorias.class);
            categorias.setEstado(Status.ACTIVE);
            categorias.setFechaCreacion(date);
            categorias = categoriasRepository.save(categorias);

            return categorias;

        }catch (Exception e){
            log.info("A expeted error: " + e.getMessage());
            throw  new CustomException("A expeted error: " + e.getMessage());
        }
    }

    @Override
    public Categorias updateCategorria(CategoriasDto dto) {
        try {
            Date date = new Date();
            Categorias categorias = modelMapper.map(dto,Categorias.class);
            categorias.setEstado(Status.ACTIVE);
            categorias.setFechaCreacion(date);
            categorias = categoriasRepository.save(categorias);

            return categorias;

        }catch (Exception e){
            log.info("A expeted error: " + e.getMessage());
            throw  new CustomException("A expeted error: " + e.getMessage());
        }
    }

    @Override
    public String deleteCategoria(Long id) {
        try {
            Categorias categoria = categoriasRepository.findById(id).orElseThrow(()-> new CustomException("Register whit id : "+id +"not foud"));
            categoriasRepository.delete(categoria);
            return "Registry deleted successfully";
        }catch (Exception e){
            throw  new CustomException("A expeted error: " + e.getMessage());
        }
    }

}
