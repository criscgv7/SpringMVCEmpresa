package com.Controllers;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

import com.entities.Empleado;
import com.entities.Departamento;
import com.entities.Telefono;
import com.services.EmpleadoService;
import com.services.DepartamentoService;
import com.services.TelefonoService;
import com.services.CorreoService;

@Controller
@RequestMapping("/")

public class MainController {

    private static final Logger LOG = Logger.getLogger("MainController");
    @Autowired
    private DepartamentoService departamentoService;
    @Autowired
    private EmpleadoService empleadoService;
    @Autowired
    private TelefonoService telefonoService;
    @Autowired
    private CorreoService correoService;

    /**
     * 1. LISTADO DE EMPLEADOS
     */
    @GetMapping("/listado")
    public ModelAndView listar() {

        List<Empleado> empleados = empleadoService.findAll();

        ModelAndView mav = new ModelAndView("views/listadoEmpleados");
        mav.addObject("empleados", empleados);
        return mav;
    }

/**
 * 2. DAR DE ALTA UN EMPLEADO - FORMULARIO
 */
/** 

 //FORMULARIO
 @GetMapping("/formulario")
 public String formularioAltaEmpleado(Model model) {

     List<Departamento> departamentos = departamentoService.findAll();
     Empleado empleado = new Empleado();

     model.addAttribute("empleado", empleado);
     model.addAttribute("departamentos", departamentos); 

     return "views/formularioAltaEmpleado";

 }

 //ALTA
 @PostMapping("/altaModificacionEmpleado")
 public String altaModificacionEmpleado(@ModelAttribute Empleado empleado,
         @RequestParam(name = "numerosTelefonos") String telefonosRecibidos) {
     LOG.info("Telefonos recibidos:" + telefonosRecibidos);

     empleadoService.save(empleado);

   
     empleadoService.save(empleado);
     List<String> listadoNumerosTelefonos = null;

     if (telefonosRecibidos != null) {
         String[] arrayTelefonos = telefonosRecibidos.split(";");
         listadoNumerosTelefonos = Arrays.asList(arrayTelefonos);
     }

     // Borrar todos los telefonos que tenga el empleado si hay que insertar nuevos

     if (listadoNumerosTelefonos != null) {
         listadoNumerosTelefonos.stream().forEach(n -> {
             Telefono telefonoObject = Telefono.builder().numero(n).empleado(empleado).build();

             telefonoService.save(telefonoObject);

         });
     }

     return "redirect:/listado";
 }

**/
}
