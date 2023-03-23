package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entities.Empleado;

public interface EmpleadoDao  extends JpaRepository <Empleado, Integer>{
    
}
