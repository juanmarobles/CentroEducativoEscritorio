/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.entidades.Alumno;
import logica.entidades.Docente;
import logica.entidades.Tutor;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author juanmarobles
 */
public class PersistenciaController {

    RolJpaController rolJPA = new RolJpaController();
    UsuarioJpaController usuJPA = new UsuarioJpaController();
    UsuarioRolJpaController usuorolJPA = new UsuarioRolJpaController();
    AlumnoJpaController aluJPA = new AlumnoJpaController();
    CuotaJpaController cuotaJPA = new CuotaJpaController();
    TutorJpaController tutorJPA = new TutorJpaController();
    DocenteJpaController docJPA = new DocenteJpaController();

    /* ------------------------------------CRUD ALUMNOS--------------------------------------------------------*/
        //save
    public void guardarAlumno(Alumno alumno) {
        aluJPA.create(alumno);
    }
    //listar

    public List<Alumno> traerAlumnos() {
        return aluJPA.findAlumnoEntities();
    }
    //listar x id

    public Alumno traerAlumno(Long idAlumno) {
        return aluJPA.findAlumno(idAlumno);
    }
    //delete

    public void borrarAlumno(Long idAlumno) {
        try {
            aluJPA.destroy(idAlumno);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PersistenciaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //editar
    public void editarAlumno(Alumno alumno) {
        try {
            aluJPA.edit(alumno);
        } catch (Exception ex) {
            Logger.getLogger(PersistenciaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /* ------------------------------------CRUD TUTORES--------------------------------------------------------*/
    //crear
    public void guardarTutor(Tutor tutor) {
        tutorJPA.create(tutor);
    }

    public Tutor buscarTutorPornombre(String tutorNombre) {
        return tutorJPA.buscarTutorPorNombre(tutorNombre);
    }

    /* ------------------------------------CRUD DOCENTES--------------------------------------------------------*/

    public List<Docente> traerDocentes() {
        return docJPA.findDocenteEntities();
    }

    public void crearDocente(Docente d) {
        docJPA.create(d);
    }

    public void editarDocente(Docente docente) {
        try {
            docJPA.edit(docente);
        } catch (Exception ex) {
            Logger.getLogger(PersistenciaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Docente traerDocente(int idDocente) {
        return docJPA.findDocente(idDocente);
    }

}
