/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package logica.entidades;

/**
 *
 * @author juanmarobles
 */
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import java.util.List;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Curso implements Serializable {
    
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cursoId;
    
    @ManyToMany
    @JoinTable(
        name = "curso_docente",
        joinColumns = @JoinColumn(name = "curso_id"),
        inverseJoinColumns = @JoinColumn(name = "docente_id")
    )
    private List<Docente> docentes;

    @ManyToMany
    @JoinTable(
        name = "curso_materia",
        joinColumns = @JoinColumn(name = "curso_id"),
        inverseJoinColumns = @JoinColumn(name = "materia_id")
    )
    private List<Materia> materias;


    public List<Docente> getDocentes() {
        return docentes;
    }

    public int getCursoId() {
        return cursoId;
    }

    public void setCursoId(int cursoId) {
        this.cursoId = cursoId;
    }
    

    public void setDocentes(List<Docente> docentes) {
        this.docentes = docentes;
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }
}
