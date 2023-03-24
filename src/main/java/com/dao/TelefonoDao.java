package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entities.Empleado;
import com.entities.Telefono;

public interface TelefonoDao extends JpaRepository <Telefono, Integer> {
    
    long deleteByEmpleado(Empleado empleado);

    List<Telefono> findByEmpleado(Empleado empleado); }
