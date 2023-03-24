package com.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import com.entities.Departamento;

public interface DepartamentoDao extends JpaRepository <Departamento, Integer> {
    
}
