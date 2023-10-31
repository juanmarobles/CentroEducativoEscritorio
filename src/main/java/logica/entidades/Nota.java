/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author juanmarobles
 */
@Entity
@Table(name = "notas")
public class Nota implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idNota;

    private Alumno alumno;
   
    private Materia materia;

    private Docente docente;

    private int valor;

    public Nota() {
    }

    public Nota(int idNota, Alumno alumno, Materia materia, Docente docente, int valor) {
        this.idNota = idNota;
        this.alumno = alumno;
        this.materia = materia;
        this.docente = docente;
        this.valor = valor;
    }

    public Nota(int valor) {
        this.valor = valor;
    }
    

    public int getIdNota() {
        return idNota;
    }

    public void setIdNota(int idNota) {
        this.idNota = idNota;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    

}
