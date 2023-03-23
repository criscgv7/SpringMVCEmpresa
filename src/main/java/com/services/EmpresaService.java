package com.example.services;

import java.util.List;

import com.entities.Empresa;

public interface EmpresaService {
    public List <Empresa> findAll();
    public Empresa findById (int idEmpresa);
    public void save (Empresa empresa); 
    public void deleteById (int idEmpresa); 
    
 
    
}
