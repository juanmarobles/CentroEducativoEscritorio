/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.entidades.Alumno;
import logica.entidades.Aula;
import logica.entidades.Docente;
import logica.entidades.Materia;
import logica.entidades.Nota;
import logica.entidades.Personal;
import logica.entidades.Tutor;
import logica.entidades.Usuario;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author juanmarobles
 */
public class PersistenciaController {

    UsuarioJpaController usuJPA = new UsuarioJpaController();
    AlumnoJpaController aluJPA = new AlumnoJpaController();
    CuotaJpaController cuotaJPA = new CuotaJpaController();
    TutorJpaController tutorJPA = new TutorJpaController();
    DocenteJpaController docJPA = new DocenteJpaController();
    PersonalJpaController personalJPA = new PersonalJpaController();
    MateriaJpaController matJPA = new MateriaJpaController();
    NotaJpaController notJPA = new NotaJpaController();

    /* ------------------------------------CRUD USUARIOS--------------------------------------------------------*/
    public void crearUsuario(Usuario usuario) {
        usuJPA.create(usuario);
    }


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

    public Alumno traerAlumno(int idAlumno) {
        return aluJPA.findAlumno(idAlumno);
    }
    //delete

    public void borrarAlumno(int idAlumno) {
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

    //edit
    public void EditarTutor(Tutor tutor) {
        try {
            tutorJPA.edit(tutor);
        } catch (Exception ex) {
            Logger.getLogger(PersistenciaController.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    public void borrarDocente(int idDocente) {
        try {
            docJPA.destroy(idDocente);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PersistenciaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /* ------------------------------------CRUD TUTORES--------------------------------------------------------*/

    public void borrarTutor(int idTutor) {
        try {
            tutorJPA.destroy(idTutor);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PersistenciaController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<Tutor> traerTutores() {
        return tutorJPA.findTutorEntities();
    }

    public Tutor traerTutor(int idTutor) {
        return tutorJPA.findTutor(idTutor);
    }

    /* ------------------------------------CRUD PERSONAL--------------------------------------------------------*/
    public void borrarPersonal(int idPersonal) {
        try {
            personalJPA.destroy(idPersonal);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PersistenciaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void crearPersonal(Personal p) {
        personalJPA.create(p);
    }

    public List<Personal> traerPersonal() {
        return personalJPA.findPersonalEntities();
    }

    public void editarPersonal(Personal personal) {
        try {
            personalJPA.edit(personal);
        } catch (Exception ex) {
            Logger.getLogger(PersistenciaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Personal traerPersonal(int idPersonal) {
        return personalJPA.findPersonal(idPersonal);
    }

    /* ------------------------------------CRUD MATERIA--------------------------------------------------------*/
    public void asignarMateria(Materia m, Docente docente, Aula aula) {
        matJPA.asignarMateriaADocente(m, docente, aula);
    }

    public List<Materia> traerMaterias() {
        return matJPA.findMateriaEntities();
    }

    public void asignarMateriaAlumno(Materia m, Alumno alumno) {
        matJPA.asignarMateriaAAlumno(m, alumno);
    }

    public void asignarNotaAlumno(Nota nuevaNota) {
        notJPA.create(nuevaNota);
    }

    public void asignarMateriaNueva(Materia m) {
        matJPA.create(m);
    }

    public void eliminarMateria(int idMateria) {
        try {
            matJPA.destroy(idMateria);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PersistenciaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Materia buscarMateriaPorNombre(String materia) {
        return matJPA.buscarMateriaPorNombre(materia);
    }

}
