package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entities.Correo;
import com.entities.Empleado;

public interface CorreoDao extends JpaRepository <Correo, Integer>{
    long deleteByEmpleado(Empleado empleado);

    List<Correo> findByEmpleado(Empleado empleado); }
 

