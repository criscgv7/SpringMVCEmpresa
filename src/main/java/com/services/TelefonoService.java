package com.services;

import java.util.List;

import com.entities.Empleado;
import com.entities.Telefono;

public interface TelefonoService {

    public List <Telefono> findAll();
    public Telefono findById (int idTelefono);
    public void save (Telefono telefono); 
    public void deleteById (int idTelefono); 
  /*   public void deleteByEmpleado(Empleado empleado); 
    public List <Telefono> findByEmpleado(Empleado empleado);*/
   

    
}
