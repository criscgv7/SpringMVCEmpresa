package com.services;

import java.util.List;

import com.entities.Correo;
import com.entities.Empleado;

public interface CorreoService {
  
    public List <Correo> findAll();
    public Correo findById (int idCorreo);
    public void save (Correo correo); 
    public void deleteById (int idCorreo);  
    
    public void deleteByEmpleado(Empleado empleado);

    public List<Correo> findByEmpleado(Empleado empleado); 
}
