/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.entidades;

import javax.persistence.Entity;
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
public class DocenteMateria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String dia;
    private String desde;
    private String hasta;
    @ManyToOne
    @JoinColumn(name = "docente_id")
    private Docente docente;

    @ManyToOne
    @JoinColumn(name = "materia_id")
    private Materia materia;
    
    @ManyToOne
    @JoinColumn(name = "aula_id")
    private Aula aula;

    public DocenteMateria() {
    }

    public DocenteMateria(int id, String dia, String desde, String hasta, Docente docente, Materia materia, Aula aula) {
        this.id = id;
        this.dia = dia;
        this.desde = desde;
        this.hasta = hasta;
        this.docente = docente;
        this.materia = materia;
        this.aula = aula;
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

}
