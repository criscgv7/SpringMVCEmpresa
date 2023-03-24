package com.services;

import java.util.List;

import com.entities.Departamento;


public interface DepartamentoService {
    public List <Departamento> findAll();
    public Departamento findById (int idDepartamento);
    public void save (Departamento departamento); 
    public void deleteById (int idDepartamento); 
    
 
    
}
