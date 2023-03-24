package com;

import java.time.LocalDate;
import java.time.Month;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.entities.Departamento;
import com.entities.Empleado;
import com.entities.Empleado.Genero;
import com.services.DepartamentoService;
import com.services.EmpleadoService;

@SpringBootApplication
public class SpringMvcEmpresaApplication implements CommandLineRunner {

	@Autowired
	private DepartamentoService departamentoService;
	@Autowired
	private EmpleadoService empleadoService;
	

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcEmpresaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		/*
		 * AGREGANDO MUESTRAS
		 */

		departamentoService.save(Departamento.builder().nombre("Informática").build());
		departamentoService.save(Departamento.builder().nombre("RRHH").build());
		departamentoService.save(Departamento.builder().nombre("Contabilidad").build());




		empleadoService.save(Empleado.builder().id(1).nombre("Dayana")
		.apellidos("Díaz Corbalán")
		.fechaAlta(LocalDate.of(1993, Month.APRIL, 20))
		.genero(Genero.MUJER)
		.departamento(departamentoService.findById(1)).build());

		empleadoService.save(Empleado.builder().id(2).nombre("Irene")
		.apellidos("Galindo Velasco")
		.fechaAlta(LocalDate.of(1983, Month.AUGUST, 21))
		.genero(Genero.MUJER)
		.departamento(departamentoService.findById(2)).build());

		empleadoService.save(Empleado.builder().id(3).nombre("Belén")
		.apellidos("Martinez Perez")
		.fechaAlta(LocalDate.of(1996, Month.DECEMBER, 23))
		.genero(Genero.MUJER)
		.departamento(departamentoService.findById(3)).build());
	}

}
