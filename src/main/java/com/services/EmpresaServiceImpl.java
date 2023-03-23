package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.dao.EmpresaDao;
import com.entities.Empresa;

public class EmpresaServiceImpl implements EmpresaService {
    @Autowired
    private EmpresaDao empresaDao;

    @Override
    public List<Empresa> findAll() {
        return empresaDao.findAll();

    }

    @Override
    public Empresa findById(int idEmpresa) {
        return empresaDao.findById(idEmpresa).get();
    }

    @Override
    @Transactional
    public void save(Empresa empresa) {
        empresaDao.save(empresa);
    }

    @Override
    @Transactional
    public void deleteById(int idEmpresa) {
        empresaDao.deleteById(idEmpresa);
    }

}
