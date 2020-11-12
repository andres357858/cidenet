package com.cidenet.prueba.controller.impl;

import com.cidenet.prueba.controller.EmpleadoController;
import com.cidenet.prueba.dto.Mensaje;
import com.cidenet.prueba.dto.EmpleadoDto;
import com.cidenet.prueba.entity.Empleado;
import com.cidenet.prueba.service.impl.EmpleadoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EmpleadoControllerImpl implements EmpleadoController{

    @Autowired
    EmpleadoServiceImpl empleadoService;


    private static final String NO_EXISTE ="Empleado no existe";
    private static final String ELIMINADO ="Empleado eliminado";
    private static final String ACTUALIZADO ="Empleado actualizado";
    private static final String CREADO ="Empleado creado";

    @Override
    public ResponseEntity<List<Empleado>> list(){
        log.info("Consultando lista de empleados, metodo : list()");
        List<Empleado> list = null;
        try {
            list = empleadoService.list();
        } catch (Exception e) {
             return new ResponseEntity(new Mensaje(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(list, HttpStatus.OK);
    }


    @Override
    public ResponseEntity getById(@PathVariable("id") int id){
        log.info("Consultando empleados por id, id{}",id);
        Empleado empleado = null;
        try {
            if (!empleadoService.existsById(id)) {
                return new ResponseEntity(new Mensaje(NO_EXISTE), HttpStatus.NOT_FOUND);
            }
            empleado = empleadoService.getOne(id).get();
        } catch (Exception e) {
             return new ResponseEntity(new Mensaje(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(empleado, HttpStatus.OK);
    }

    @Override
    public ResponseEntity create(@RequestBody EmpleadoDto empleadoDto){
        log.info("Creando un nuevo empleado, empleadoDto{}",empleadoDto);
        try {
            empleadoService.save(0, empleadoDto);
        } catch (Exception e) {
             return new ResponseEntity(new Mensaje(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
        
        return new ResponseEntity(new Mensaje(CREADO), HttpStatus.OK);
    }

    @Override
    public ResponseEntity update(@PathVariable("id")int id, @RequestBody EmpleadoDto empleadoDto){
        log.info("Actualizando un empleado, empleadoDto{} id{}",empleadoDto,id);
        try {
            if (!empleadoService.existsById(id)) {
                return new ResponseEntity(new Mensaje(NO_EXISTE), HttpStatus.NOT_FOUND);
            }
            
            empleadoService.save(id, empleadoDto);
            return new ResponseEntity(new Mensaje(ACTUALIZADO), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(new Mensaje(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity delete(@PathVariable("id")int id){
        log.info("Eliminando un empleado, id{}",id);

        try {
            if (!empleadoService.existsById(id)) {
                return new ResponseEntity(new Mensaje(NO_EXISTE), HttpStatus.NOT_FOUND);
            }
            empleadoService.delete(id);
            return new ResponseEntity(new Mensaje(ELIMINADO), HttpStatus.OK);
        } catch (Exception e) {
             return new ResponseEntity(new Mensaje(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

}
