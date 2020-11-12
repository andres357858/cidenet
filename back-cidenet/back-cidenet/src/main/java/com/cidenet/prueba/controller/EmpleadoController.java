package com.cidenet.prueba.controller;

import com.cidenet.prueba.dto.EmpleadoDto;
import com.cidenet.prueba.entity.Empleado;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/empleado")
@CrossOrigin(origins = "*")
public interface EmpleadoController {

    @GetMapping("/lista")
    public ResponseEntity<List<Empleado>> list();

    @GetMapping("/detail/{id}")
    public ResponseEntity<Empleado> getById(@PathVariable("id") int id);

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody EmpleadoDto empleadoDto);

    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable("id")int id, @RequestBody EmpleadoDto empleadoDto);

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id")int id);

}
