package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.Empresa;

public interface EmpresaDao extends JpaRepository <Empresa, Integer> {
    
}
