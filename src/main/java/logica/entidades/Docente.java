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

/**
 *
 * @author juanmarobles
 */
@Entity
public class Docente extends Persona implements Serializable {

    private String turno;
    private String nivel;

    @ManyToMany
    @JoinTable(
            name = "docente_curso",
            joinColumns = @JoinColumn(name = "docente_id"),
            inverseJoinColumns = @JoinColumn(name = "curso_id")
    )
    private List<Curso> cursos;

    @ManyToMany
    @JoinTable(
            name = "docente_materia",
            joinColumns = @JoinColumn(name = "docente_id"),
            inverseJoinColumns = @JoinColumn(name = "materia_id")
    )
    private List<Materia> materias;

    public Docente() {
    }

    public Docente(String turno, String nivel, List<Curso> cursos, List<Materia> materias, String nombre, String apellido, int idPersona, int dni, int telefono, String domicilio, String email) {
        super(nombre, apellido, idPersona, dni, telefono, domicilio, email);
        this.turno = turno;
        this.nivel = nivel;
        this.cursos = cursos;
        this.materias = materias;
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

   
    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

}
