package com.cidenet.prueba.service;

import com.cidenet.prueba.dto.EmpleadoDto;
import com.cidenet.prueba.entity.Empleado;
import java.util.List;
import java.util.Optional;

public interface EmpleadoService {

    /**
     * Metodo encargado de consultar la lista de empleados
     * @return
     */
    List<Empleado> list();

    /**
     * metodo encargado de cunsultar un empleado por id
     * @param id
     * @return 
     */
    Optional<Empleado> getOne(int id);

    /**
     * metodo encargado de guardar y actualiar un empleado 
     * @param id
     * @param empleadoDto 
     */
    void save(int id, EmpleadoDto empleadoDto);

    /**
     * metodo encargado de eliminar un empleado
     * @param id 
     */
    void delete(int id);

    /**
     * metodo encargado de verificar si existe un empleado con un id especifico
     * @param id
     * @return 
     */
    boolean existsById(int id);

}
