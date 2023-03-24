package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CorreoDao;
import com.entities.Correo;
import com.entities.Empleado;

import jakarta.transaction.Transactional;

@Service
public class CorreoServiceImpl implements CorreoService {
   
     @Autowired
    private CorreoDao correoDao; 
    
    @Override
    public List<Correo> findAll() {
        return correoDao.findAll(); 
    }
    
    @Override
    public Correo findById(int idTelefono) {
      return correoDao.findById(idTelefono).get(); }
    
    @Override
    @Transactional
    public void save(Correo correo) {
       
            correoDao.save(correo); 
    }
    
    @Override
    public void deleteById(int idCorreo) {
        correoDao.deleteById(idCorreo);
    }

    @Override
@Transactional
public void deleteByEmpleado(Empleado empleado) {
    correoDao.deleteByEmpleado(empleado); 
}

@Override

public List <Correo> findByEmpleado(Empleado empleado) {
 return correoDao.findByEmpleado(empleado); 

}   


}
