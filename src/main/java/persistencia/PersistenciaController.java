/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.util.List;
import logica.entidades.Alumno;

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
    TutorJpaController tutorJpa = new TutorJpaController();
    

    public void guardarAlumno(Alumno alumno) {
            aluJPA.create(alumno);
    }

    public List<Alumno> traerAlumnos() {
       return aluJPA.findAlumnoEntities();
    }

    public Alumno traerAlumno(Long idAlumno) {
        return aluJPA.findAlumno(idAlumno);
    }
    
}
