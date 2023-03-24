package com.Controllers;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.entities.Correo;
import com.entities.Departamento;
import com.entities.Empleado;
import com.entities.Telefono;
import com.services.CorreoService;
import com.services.DepartamentoService;
import com.services.EmpleadoService;
import com.services.TelefonoService;

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

    // FORMULARIO
    @GetMapping("/formulario")
    public String formularioAltaEmpleado(Model model) {

        List<Departamento> departamentos = departamentoService.findAll();
        Empleado empleado = new Empleado();

        model.addAttribute("empleado", empleado);
        model.addAttribute("departamentos", departamentos);

        return "views/formularioAltaEmpleado";

    }

    // ALTA
    @PostMapping("/altaModificacionEmpleado")

    public String altaModificacionEmpleado(@ModelAttribute Empleado empleado,
            @RequestParam(name = "numerosTelefonos") String telefonosRecibidos,
            @RequestParam(name = "correosEmail") String correosRecibidos) {

        LOG.info("Telefonos Recibidos:" + telefonosRecibidos);
        LOG.info("Correos Recibidos:" + correosRecibidos);

        empleadoService.save(empleado);
        empleadoService.save(empleado);

        List<String> listadoTelefonos = null;
        List<String> listadoCorreos = null;

        if (telefonosRecibidos != null) {
            String[] arrayTel = telefonosRecibidos.split(";");
            listadoTelefonos = Arrays.asList(arrayTel);
        }

        if (listadoTelefonos != null) {

            listadoTelefonos.stream().forEach(n -> {
                Telefono telefonoObject = Telefono.builder().numero(n).empleado(empleado).build();

                telefonoService.save(telefonoObject);
            });
        }

        if (correosRecibidos != null) {
            String[] arrayCo = correosRecibidos.split(";");
            listadoCorreos = Arrays.asList(arrayCo);
        }
        if (listadoCorreos != null) {
            listadoCorreos.stream().forEach(n -> {
                Correo correoObject = Correo.builder().email(n).empleado(empleado).build();

                correoService.save(correoObject);
            });
        }

        return "redirect:/listado";

    }
}