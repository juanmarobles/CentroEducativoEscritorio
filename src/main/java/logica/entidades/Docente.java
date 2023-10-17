/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author juanmarobles
 */
@Entity
public class Docente extends Persona implements Serializable {

    private String turno;
    private String nivel;

     private String materia;

    public Docente() {
    }

    public Docente(String turno, String nivel, String materia, String nombre, String apellido, int idPersona, int dni, int telefono, String domicilio, String email) {
        super(nombre, apellido, idPersona, dni, telefono, domicilio, email);
        this.turno = turno;
        this.nivel = nivel;
        this.materia = materia;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

   

   



}
