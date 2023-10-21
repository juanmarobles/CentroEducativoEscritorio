/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author juanmarobles
 */
@Entity
@Table(name = "materias")
public class Materia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMateria;
    private String dia;
    private String desde;
    private String hasta;
    private String materia;
    @ManyToMany(mappedBy = "materias")
    private List<Docente> docentes = new ArrayList<>();
    @ManyToMany(mappedBy = "materias")
    private List<Alumno> alumnos = new ArrayList<>();

    @OneToMany(mappedBy = "materia")
    private List<Nota> notas = new ArrayList<>();
    ;
    
    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Aula aula; // Representa el curso o aula en el que se imparte la materia

    public Materia() {
    }

    public Materia(int idMateria, String dia, String desde, String hasta, String materia, List<Docente> docentes, List<Alumno> alumnos) {
        this.idMateria = idMateria;
        this.dia = dia;
        this.desde = desde;
        this.hasta = hasta;
        this.docentes = docentes;
        this.alumnos = alumnos;
        this.materia = materia;
        notas = new ArrayList<>();
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }
    

    public List<Nota> getNotas() {
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }



    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getDesde() {
        return desde;
    }

    public void setDesde(String desde) {
        this.desde = desde;
    }

    public String getHasta() {
        return hasta;
    }

    public void setHasta(String hasta) {
        this.hasta = hasta;
    }

    public List<Docente> getDocentes() {
        return docentes;
    }

    public void setDocentes(List<Docente> docentes) {
        this.docentes = docentes;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    @Override
    public String toString() {
        return materia;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true; // Si se compara con el mismo objeto, son iguales.
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false; // Si el objeto no es de la misma clase, no son iguales.
        }
        Materia otherMateria = (Materia) obj; // Realiza un casting del objeto a Materia.
        // Compara las materias por nombre u otro criterio, por ejemplo:
        return Objects.equals(this.materia, otherMateria.materia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.materia);
    }

}
