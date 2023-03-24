package com.services;

import java.util.List;

import com.entities.Correo;

public interface CorreoService {
  
    public List <Correo> findAll();
    public Correo findById (int idCorreo);
    public void save (Correo correo); 
    public void deleteById (int idCorreo);   
}
