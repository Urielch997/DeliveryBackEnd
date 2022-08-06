package com.deliveryApp.Delivery.configParameters.controller;

import com.deliveryApp.Delivery.configParameters.service.CategoriaService;
import com.deliveryApp.Delivery.utils.ServiceResponse;
import com.deliveryApp.Delivery.utils.ServiceResponseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("")
    public ResponseEntity<ServiceResponse> listCategorias(){
        return ServiceResponseFactory.createResponse(categoriaService.listCategorias());
    }

}

