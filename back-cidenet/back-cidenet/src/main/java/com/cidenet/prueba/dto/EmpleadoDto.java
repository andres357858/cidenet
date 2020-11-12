package com.cidenet.prueba.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpleadoDto {
    
    private String primerApellido;
    private String segundoApellido;
    private String primerNombre;
    private String otroNombre;
    private String pais;
    private String tipoIdentificacion;
    private String numIdentificacion;
    private Date fechaIngreso;
    private String area;


}
