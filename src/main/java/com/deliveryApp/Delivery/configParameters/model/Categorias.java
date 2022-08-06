package com.deliveryApp.Delivery.configParameters.model;

import com.deliveryApp.Delivery.configParameters.Enums.Status;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "categorias",schema = "configuracion_parametros")
public class Categorias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategoria;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "estado")
    private Status estado;

    @Column(name = "fecha_creacion")
    private Date fechaCreacion;

    @Column(name = "codigo")
    private String codigo;

    public Categorias(Long idCategoria, String nombre, String descripcion, Status estado, Date fechaCreacion,String codigo) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.codigo = codigo;
    }

    public Categorias() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Status getEstado() {
        return estado;
    }

    public void setEstado(Status estado) {
        this.estado = estado;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
