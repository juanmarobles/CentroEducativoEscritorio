/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.List;
import logica.entidades.Alumno;
import persistencia.PersistenciaController;

/**
 *
 * @author juanmarobles
 */
public class EntidadesController {
    
        PersistenciaController ctrl = new PersistenciaController();

    /**
     --------------------------------------Verificacion Usuario-------------------------------------------------
     */
    public boolean validarUsuario(String usuario, String password) {
        return true;
        /*
        List<Usuario> listaUsuarios = ctrl.traerUsuarios();
        boolean usuarioValido = false;

        for (Usuario usu : listaUsuarios) {
            if (usu.getUsuario().equals(usuario) && usu.getContraseña().equals(password)) {
                usuarioValido = true;
                break;
            }
        }

        return usuarioValido;
        */
    }
         /* ------------------------------------CRUD ALUMNOS--------------------------------------------------------*/

    public void borrarAlumno(Long idAlumno) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<Alumno> traerAlumnos() {
        return ctrl.traerAlumnos();
    }

    public void cargarAlumno(String nombre, String apellido, int dni,int Telefono, String tutor, String nivel, String division) {
        Alumno alumno = new Alumno();
        alumno.setNombre(nombre);
        alumno.setApellido(apellido);
        alumno.setDni(dni);
        alumno.setTelefono(Telefono);
        alumno.setTutor(tutor);
        alumno.setNivel(nivel);
        alumno.setDivision(division);
        
        
        ctrl.guardarAlumno(alumno);
        
    }

    public void editarAlumno() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Alumno traerAlumno(Long idAlumno) {
             return ctrl.traerAlumno(idAlumno);
        }
    
}
