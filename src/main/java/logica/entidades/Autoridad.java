/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author juanmarobles
 */
@Entity
public class Autoridad implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idAutoridad;
    
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    public Autoridad() {
    }

    public Autoridad(int idAutoridad, String nombre, String apellido) {
        this.idAutoridad = idAutoridad;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public int getIdAutoridad() {
        return idAutoridad;
    }

    public void setIdAutoridad(int idAutoridad) {
        this.idAutoridad = idAutoridad;
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
