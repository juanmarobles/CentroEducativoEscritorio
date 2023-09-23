/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.entidades;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.io.Serializable;

/**
 *
 * @author juanm
 */
public class Persona {
    private String nombre;
    private String apellido;
    private int dni;
    private int edad;
    private String sexo;
    private LocalDate fechaNacimiento;
    private static final DateTimeFormatter fechaFormato = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public Persona() {
    }

    public Persona(String nombre, String apellido, int dni, int edad, String sexo, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.edad = edad;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    public String getFormatoFechaNacimiento() {
        return fechaNacimiento.format(fechaFormato);
    }
   

    
}
