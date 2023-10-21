/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author juanmarobles
 */
@Entity
@Table(name = "alumnos")
public class Alumno extends Usuario implements Serializable {

    @ManyToOne
    @JoinColumn(name = "tutor_id")
    private Tutor tutor;

    @Column(name = "nivel")
    private String nivel;

    @Column(name = "division")
    private String division;

    @Column(name = "fecha_nac")
    private String fechaNac;

    @ManyToMany
    @JoinTable(
            name = "alumno_curso",
            joinColumns = @JoinColumn(name = "alumno_id"),
            inverseJoinColumns = @JoinColumn(name = "curso_id")
    )
    private List<Aula> aulas = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "alumno_materia",
            joinColumns = @JoinColumn(name = "alumno_id"),
            inverseJoinColumns = @JoinColumn(name = "materia_id")
    )
    private List<Materia> materias = new ArrayList<>();

    @OneToMany(mappedBy = "alumno")
    private List<Nota> notas;

    public Alumno() {

    }

    public Alumno(Tutor tutor, String nivel, String division, String fechaNac, List<Nota> notas, int id, String usuario, String contrasena, String nombre, String apellido, int dni, int telefono, String domicilio, String email, String rol) {
        super(id, usuario, contrasena, nombre, apellido, dni, telefono, domicilio, email, rol);
        this.tutor = tutor;
        this.nivel = nivel;
        this.division = division;
        this.fechaNac = fechaNac;
        this.notas = notas;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }

    public List<Nota> getNotas() {
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }

    @Override
    public String toString() {
        return getNombre();
    }

}
