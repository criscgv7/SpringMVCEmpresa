package com.Controllers;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

    /**
     * 3.ACTUALIZAR UN EMPLEADO
     */

    /** FOrmulario para actualizar un estudiante */
    @GetMapping("/formularioActualizar/{id}")
    public String formularioActualizarEstudiante(@PathVariable(name = "id") int idEmpleado, Model model) {
        Empleado empleado = empleadoService.findById(idEmpleado);

        List<Telefono> todosTelefonos = telefonoService.findAll();
        List<Telefono> telefonosDelEmpleado = todosTelefonos.stream()
                .filter(telefono -> telefono.getEmpleado().getId() == idEmpleado).toList();
        String numerosDeTelefono = telefonosDelEmpleado.stream().map(telefono -> telefono.getNumero())
                .collect(Collectors.joining(";"));

        List<Correo> todosCorreos = correoService.findAll();
        List<Correo> correosDelEmpleado = todosCorreos.stream()
                .filter(correo -> correo.getEmpleado().getId() == idEmpleado).toList();
        String correosDeEmail = correosDelEmpleado.stream().map(correo -> correo.getEmail())
                .collect(Collectors.joining(";"));

        List<Departamento> departamentos = departamentoService.findAll();

        model.addAttribute("empleado", empleado);
        model.addAttribute("telefonos", numerosDeTelefono);
        model.addAttribute("telefonos", correosDeEmail);

        model.addAttribute("departamentos", departamentos);

        return "views/formularioAltaEmpleado";
    }

    @GetMapping("/borrar/{id}")
    public String borrarEstudiante(@PathVariable(name = "id") int idEmpleado) {
        empleadoService.delete(empleadoService.findById(idEmpleado));

        return "redirect:/listado";
    }

}