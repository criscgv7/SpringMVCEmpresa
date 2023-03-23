package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entities.Correo;

public interface CorreoDao extends JpaRepository <Correo, Integer>{
    
}
