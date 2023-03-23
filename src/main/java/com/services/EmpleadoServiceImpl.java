package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.EmpleadoDao;
import com.entities.Empleado;

@Service

public class EmpleadoServiceImpl  implements EmpleadoService {
    @Autowired
    private EmpleadoDao empleadoDao; 
    @Override
    public List<Empleado> findAll() {
       return empleadoDao.findAll();
    }
    @Override
    public Empleado findById(int idEmpleado) {
        return empleadoDao.findById(idEmpleado).get();
    }
    @Override
    public void save(Empleado empleado) {
       empleadoDao.save(empleado); 
    }
    @Override
    public void deleteById(int idEmpleado) {
        empleadoDao.deleteById(idEmpleado);
    }
    @Override
    public void delete(Empleado empleado) {
       empleadoDao.delete(empleado);
    }
    
}
