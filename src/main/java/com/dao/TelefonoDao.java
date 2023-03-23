package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entities.Telefono;

public interface TelefonoDao extends JpaRepository <Telefono, Integer> {
    
}
