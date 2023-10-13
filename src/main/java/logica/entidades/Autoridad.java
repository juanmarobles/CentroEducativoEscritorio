/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author juanmarobles
 */
@Entity
public class Autoridad {
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    public Autoridad() {
    }

    public Autoridad(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
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
        

}
