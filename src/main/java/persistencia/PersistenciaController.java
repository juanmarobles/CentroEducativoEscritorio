/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.entidades.Alumno;
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
    

    public void guardarAlumno(Alumno alumno) {
            aluJPA.create(alumno);
    }

    public List<Alumno> traerAlumnos() {
       return aluJPA.findAlumnoEntities();
    }

    public Alumno traerAlumno(Long idAlumno) {
        return aluJPA.findAlumno(idAlumno);
    }

    public void guardarTutor(Tutor tutor) {
        
    }

    public void borrarAlumno(Long idAlumno) {
        try {
            aluJPA.destroy(idAlumno);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PersistenciaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Tutor buscarTutorPornombre(String tutorNombre) {
        return tutorJPA.buscarTutorPorNombre(tutorNombre);
    }
    
}
