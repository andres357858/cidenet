package com.cidenet.prueba.repository;

import com.cidenet.prueba.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {

    /**
     * Metedo para consultar si existe o no un empleado con un nombre y apellido especifico
     * @param primerNombre
     * @param primerApellido
     * @return
     */
    boolean existsByPrimerNombreAndPrimerApellido(String primerNombre, String primerApellido);
}
