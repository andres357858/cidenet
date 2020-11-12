package com.cidenet.prueba.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String primerApellido;
    private String segundoApellido;
    private String primerNombre;
    private String otroNombre;
    private String pais;
    private String tipoIdentificacion;
    private String numIdentificacion;
    private String correo;
    private Date fechaIngreso;
    private String area;
    private String estado;
    private Date fechaRegistro;

}
