package com.deliveryApp.Delivery.configParameters.Dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class CategoriasDto {

    private Long idCategoria;

    private String nombre;

    private String descripcion;

}
