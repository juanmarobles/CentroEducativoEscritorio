/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author juanmarobles
 */
@Entity
public class Docente extends Usuario implements Serializable {

    private String turno;
    private String nivel;

    @ManyToMany
    @JoinTable(name = "docente_materia",
            joinColumns = @JoinColumn(name = "docente_id"),
            inverseJoinColumns = @JoinColumn(name = "materia_id")
    )
    private List<Materia> materias = new ArrayList<>();
    
    @OneToMany(mappedBy = "docente")
    private List<Nota> notas;

    public Docente() {
    }

    public Docente(String turno, String nivel, List<Nota> notas, int id, String usuario, String contrasena, String nombre, String apellido, int dni, int telefono, String domicilio, String email, String rol) {
        super(id, usuario, contrasena, nombre, apellido, dni, telefono, domicilio, email, rol);
        this.turno = turno;
        this.nivel = nivel;
        this.notas = notas;
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

    public List<Nota> getNotas() {
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }
  

    @Override
    public String toString() {
        return getNombre() + " " + getApellido()+"\n";
    }

}
