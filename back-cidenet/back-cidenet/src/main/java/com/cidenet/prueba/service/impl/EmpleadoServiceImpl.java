package com.cidenet.prueba.service.impl;

import com.cidenet.prueba.dto.EmpleadoDto;
import com.cidenet.prueba.entity.Empleado;
import com.cidenet.prueba.repository.EmpleadoRepository;
import com.cidenet.prueba.service.EmpleadoService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    EmpleadoRepository empleadoRepository;
    private Random randon = new Random();
    private static final String DOMINIO_CO = "cidenet.com.co";
    private static final String DOMINIO_US = "cidenet.com.us";
    private static final String PUNTO = ".";
    private static final String ARROBA = "@";
    private static final String COLOMBIA = "COLOMBIA";
    private static final String ESTADOS_UNIDOS = "ESTADOS_UNIDOS";
    private static final String ESTADO = "ACTIVO";

    @Override
    public List<Empleado> list() {
        log.info("Consultando lista de empleados, metodo : list()");
        return empleadoRepository.findAll();
    }

    @Override
    public Optional<Empleado> getOne(int id) {
        log.info("Consultando empleados por id, id{}", id);
        return empleadoRepository.findById(id);
    }

    @Override
    public void save(int id, EmpleadoDto empleadoDto) {
        log.info("Creando o actualizando un nuevo empleado, empleadoDto{} id{}", empleadoDto, id);

        Empleado empleado = validateUpdate(id, empleadoDto);

        empleadoRepository.save(buildEmpleado(empleadoDto, empleado));
    }

    private Empleado validateUpdate(int id, EmpleadoDto empleadoDto) {
        log.info("Validando la actualizacion de datos de un empleado,"
                + " empleadoDto{} id{}", empleadoDto, id);

        Empleado empleado = new Empleado();
        if (id != 0) {
            empleado = getOne(id).get();
            if (!empleado.getPrimerNombre().equals(empleadoDto.getPrimerNombre())
                    || !empleado.getPrimerApellido().equals(empleadoDto.getPrimerApellido())) {
                empleado.setCorreo(buildEmail(empleadoDto));
            }
        } else {
            empleado.setCorreo(buildEmail(empleadoDto));
        }
        return empleado;
    }

    private Empleado buildEmpleado(EmpleadoDto empleadoDto, Empleado empleado) {
        log.info("Construyendo Empleado a almacenar, empleadoDto{} empleado{}",
                empleadoDto, empleado);

        empleado.setPrimerApellido(empleadoDto.getPrimerApellido().toUpperCase());
        empleado.setSegundoApellido(empleadoDto.getSegundoApellido().toUpperCase());
        empleado.setPrimerNombre(empleadoDto.getPrimerNombre().toUpperCase());
        empleado.setOtroNombre(empleadoDto.getOtroNombre().toUpperCase());
        empleado.setPais(empleadoDto.getPais());
        empleado.setTipoIdentificacion(empleadoDto.getTipoIdentificacion());
        empleado.setNumIdentificacion(empleadoDto.getNumIdentificacion());
        empleado.setFechaIngreso(empleadoDto.getFechaIngreso());
        empleado.setArea(empleadoDto.getArea());
        empleado.setEstado(ESTADO);
        empleado.setFechaRegistro(new Date());

        log.info("Empleado construido, empleado{} ", empleado);
        return empleado;
    }

    private String buildEmail(EmpleadoDto empleadoDto) {
        log.info("Construyendo Email del empleado, empleadoDto{}",
                empleadoDto);
        StringBuilder sbuilder = new StringBuilder();
        sbuilder.append(empleadoDto.getPrimerNombre().toUpperCase()).append(PUNTO)
                .append(empleadoDto.getPrimerApellido().toUpperCase());

        if (empleadoRepository.existsByPrimerNombreAndPrimerApellido(
                empleadoDto.getPrimerNombre(), empleadoDto.getPrimerApellido())) {
            int valorEntero = randon.nextInt(1000);
            sbuilder.append(PUNTO).append(String.valueOf(valorEntero));
        }
        sbuilder.append(ARROBA);

        if (empleadoDto.getPais().equals(COLOMBIA)) {
            sbuilder.append(DOMINIO_CO);
        } else if (empleadoDto.getPais().equals(ESTADOS_UNIDOS)) {
            sbuilder.append(DOMINIO_US);
        }
        log.info("Correo construido correo{}",
               sbuilder.toString());
        return sbuilder.toString();

    }

    @Override
    public void delete(int id) {
        log.info("Eliminando un empleado, id{}", id);
        empleadoRepository.deleteById(id);
    }

    @Override
    public boolean existsById(int id) {
        log.info("Verificando que exista un empleado con un id especifico, id{}", id);
        return empleadoRepository.existsById(id);
    }

}
