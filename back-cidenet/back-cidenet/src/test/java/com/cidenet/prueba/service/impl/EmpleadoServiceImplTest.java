/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cidenet.prueba.service.impl;

import com.cidenet.prueba.dto.EmpleadoDto;
import com.cidenet.prueba.entity.Empleado;
import com.cidenet.prueba.repository.EmpleadoRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author ACER1
 */
@Slf4j
@RunWith(SpringRunner.class)
public class EmpleadoServiceImplTest extends TestCase {

    @Mock
    EmpleadoRepository empleadoRepository;

    @InjectMocks
    private EmpleadoServiceImpl empleadoService;

    List<Empleado> expResult;
    Empleado empleado;

    public EmpleadoServiceImplTest() {
        //
    }

    @Before
    public void setUp() {
        empleado = new Empleado();
        empleado.setPrimerApellido("CASTRO");
        empleado.setSegundoApellido("MORELO");
        empleado.setPrimerNombre("ANDRES");
        empleado.setOtroNombre("FELIPE");
        empleado.setPais("COLOMBIA");
        empleado.setTipoIdentificacion("CEDULA");
        empleado.setNumIdentificacion("1235038911");
        empleado.setCorreo("ANDRES.CASTRO@cidenet.com.co");
        empleado.setFechaIngreso(new Date());
        empleado.setArea("CONTABILIDAD");
        empleado.setEstado("ACTIVO");
        empleado.setFechaRegistro(new Date());

        expResult = new ArrayList<>();
        expResult.add(empleado);
    }

    /**
     * Test of list method, of class EmpleadoServiceImpl.
     */
    @Test
    public void testList() {
        log.info("Iniciando Test del metodo list()");
        
        when(empleadoRepository.findAll()).thenReturn(expResult);
        List<Empleado> result = empleadoService.list();

        assertEquals(expResult, result);
    }

    /**
     * Test of getOne method, of class EmpleadoServiceImpl.
     */
    @Test
    public void testGetOne() {
        log.info("Iniciando Test del metodo getOne()");

        int id = 1;
        when(empleadoRepository.findById(id)).thenReturn(Optional.of(empleado));

        Empleado expEmpleado = empleado;
        Optional<Empleado> result = empleadoService.getOne(id);
        assertEquals(expEmpleado, result.get());
    }

    /**
     * Test of save method, of class EmpleadoServiceImpl.
     */
    @Test
    public void testSave() {

        log.info("Iniciando Test del metodo save()");

        int id = 0;
        EmpleadoDto empleadoDto = new EmpleadoDto("RAMOS", "MORELO",
                "JUAN", "FELIPE", "COLOMBIA", "CEDULA",
                "1235038911", new Date(), "CONTABILIDAD");

        empleadoService.save(id, empleadoDto);

        verify(empleadoRepository, times(1)).existsByPrimerNombreAndPrimerApellido("JUAN", "RAMOS");
    }

    /**
     * Test of delete method, of class EmpleadoServiceImpl.
     */
    @Test
    public void testDelete() {
        log.info("Iniciando Test del metodo delete()");

        int id = 1;

        empleadoService.delete(id);

        verify(empleadoRepository, times(1)).deleteById(id);
    }

    /**
     * Test of existsById method, of class EmpleadoServiceImpl.
     */
    @Test
    public void testExistsById() {
        log.info("Iniciando Test del metodo existsById()");

        int id = 1;
        boolean exp = true;
        
        when(empleadoRepository.existsById(id)).thenReturn(true);

        boolean existsById = empleadoService.existsById(id);

        verify(empleadoRepository, times(1)).existsById(id);
        assertEquals(exp, existsById);
    }
}
