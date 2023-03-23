package com.Controllers;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.services.CorreoService;
import com.example.services.EmpleadoService;
import com.example.services.EmpresaService;
import com.example.services.TelefonoService;

@Controller
@RequestMapping ("/")

public class MainController {


    
private static final Logger LOG = Logger.getLogger("MainController"); 
@Autowired
private EmpresaService empresaService; 
@Autowired
private EmpleadoService empleadoService; 
@Autowired
private TelefonoService telefonoService; 
@Autowired
private CorreoService correoService; 


/**
 * 1. LISTADO DE EMPLEADOS
 */




}
