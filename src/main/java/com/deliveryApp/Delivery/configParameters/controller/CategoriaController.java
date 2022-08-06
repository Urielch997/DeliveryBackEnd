package com.deliveryApp.Delivery.configParameters.controller;

import com.deliveryApp.Delivery.configParameters.Dto.CategoriasDto;
import com.deliveryApp.Delivery.configParameters.service.CategoriaService;
import com.deliveryApp.Delivery.utils.ServiceResponse;
import com.deliveryApp.Delivery.utils.ServiceResponseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("")
    public ResponseEntity<ServiceResponse> listCategorias(){
        return ServiceResponseFactory.createResponse(categoriaService.listCategorias());
    }

    @PostMapping("")
    public ResponseEntity<ServiceResponse> crateCategoria(@RequestBody CategoriasDto dto){
        return ServiceResponseFactory.createResponse(categoriaService.createCategoria(dto));
    }

    @PutMapping("")
    public ResponseEntity<ServiceResponse> updateCategoria(@RequestBody CategoriasDto dto){
        return ServiceResponseFactory.createResponse(categoriaService.updateCategorria(dto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ServiceResponse> deleteCategoria(@PathVariable Long id){
        return ServiceResponseFactory.createResponse(categoriaService.deleteCategoria(id));
    }
}

