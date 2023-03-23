package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entities.Empresa;

public interface EmpresaDao extends JpaRepository <Empresa, Integer> {
    
}
