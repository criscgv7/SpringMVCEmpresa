package com.example.entities;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table (name = "Empleados")


public class Empleado implements Serializable {

    private static final long serialVersionUID=1L; 
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull(message = "El nombre no puede ser null")
    @Size (max=25, min=4)
    private String nombre; 
    private String apellidos;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate fechaAlta;
    private Genero genero; 
 


    public enum Genero {HOMBRE, MUJER, OTRO}
    
}

