/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.Date;
import java.util.List;
import logica.entidades.Alumno;
import logica.entidades.Docente;
import logica.entidades.Materia;
import logica.entidades.Personal;
import logica.entidades.Tutor;
import logica.entidades.Usuario;
import persistencia.PersistenciaController;

/**
 *
 * @author juanmarobles
 */
public class EntidadesController {

    PersistenciaController ctrl = new PersistenciaController();

    /**
     * --------------------------------------Verificacion Usuario-------------------------------------------------
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

    public void crearUsuario(String nombre, String apellido, String usuario, String contrasena, String rol) {
        Usuario u = new Usuario();
        u.setNombre(nombre);
        u.setApellido(apellido);
        u.setUsuario(usuario);
        u.setContrasena(contrasena);
        u.setRol(rol);
        ctrl.crearUsuario(u);
    }


    /* ------------------------------------CRUD ALUMNOS--------------------------------------------------------*/
    public void borrarAlumno(Long idAlumno) {
        ctrl.borrarAlumno(idAlumno);
    }

    public List<Alumno> traerAlumnos() {
        return ctrl.traerAlumnos();
    }

    public void cargarAlumno(String nombre, String apellido, int dni, Tutor tutor, String nivel, String division, String fecha) {
        Alumno alumno = new Alumno();
        alumno.setNombre(nombre);
        alumno.setApellido(apellido);
        alumno.setDni(dni);
        alumno.setTutor(tutor);
        alumno.setNivel(nivel);
        alumno.setDivision(division);
        alumno.setFechaNac(fecha);
        ctrl.guardarAlumno(alumno);
    }

    public void editarAlumno(Alumno alumno, String nombre, String apellido, int dni, String fecha, Tutor tutor, String nivel, String division, String fecha2) {
        alumno.setNombre(nombre);
        alumno.setApellido(apellido);
        alumno.setDni(dni);
        alumno.setTutor(tutor);
        alumno.setNivel(nivel);
        alumno.setDivision(division);
        alumno.setFechaNac(fecha);
        ctrl.editarAlumno(alumno);
    }

    public Alumno traerAlumno(Long idAlumno) {
        return ctrl.traerAlumno(idAlumno);
    }

    /* ------------------------------------CRUD TUTORES--------------------------------------------------------*/
    public void crearTutor(String nombre, String apellido, int dni, String domicilio, String email, String telefono) {
        Tutor tutor = new Tutor();
        tutor.setNombre(nombre);
        tutor.setApellido(apellido);
        tutor.setDni(dni);
        tutor.setDomicilio(domicilio);
        tutor.setEmail(email);
        tutor.setTelefono(dni);
        ctrl.guardarTutor(tutor);
    }

    public void editarTutor(Tutor tutor, String nombre, String apellido, int dni, String domicilio, String email, String telefono) {
        tutor.setNombre(nombre);
        tutor.setApellido(apellido);
        tutor.setDni(dni);
        tutor.setDomicilio(domicilio);
        tutor.setEmail(email);
        tutor.setTelefono(dni);
        ctrl.EditarTutor(tutor);
    }

    public Tutor buscarTutorPorNombre(String tutorNombre) {
        return ctrl.buscarTutorPornombre(tutorNombre);
    }

    /* ------------------------------------CRUD DOCENTES--------------------------------------------------------*/
    public List<Docente> traerDocentes() {
        return ctrl.traerDocentes();
    }

    public void cargarDocente(String nombre, String apellido, int dni, String domicilio, String tel, String email, String turno, String nivel, String materia) {
        Docente d = new Docente();
        d.setNombre(nombre);
        d.setApellido(apellido);
        d.setDni(dni);
        d.setDomicilio(domicilio);
        d.setTelefono(dni);
        d.setEmail(email);
        d.setTurno(turno);
        d.setMateria(materia); // Utiliza la materia pasada como argumento.
        d.setNivel(nivel);

        ctrl.crearDocente(d);
    }

    public void editarDocente(Docente docente, String nombre, String apellido, int dni, String domicilio, int telefono, String email, String nivel, String turno) {
        docente.setNombre(nombre);
        docente.setApellido(apellido);
        docente.setDni(dni);
        docente.setDomicilio(domicilio);
        docente.setTelefono(telefono);
        docente.setEmail(email);
        docente.setNivel(nivel);
        docente.setTurno(turno);
        ctrl.editarDocente(docente);
    }

    public Docente traerDocente(int idDocente) {
        return ctrl.traerDocente(idDocente);
    }

    public void borrarDocente(int idDocente) {
        ctrl.borrarDocente(idDocente);
    }

    public void borrarTutor(int idTutor) {
        ctrl.borrarTutor(idTutor);
    }

    public List<Tutor> traerTutores() {
        return ctrl.traerTutores();
    }

    public void borrarPersonal(int idPersonal) {
        ctrl.borrarPersonal(idPersonal);
    }

    public List<Personal> traerPersonal() {
        return ctrl.traerPersonal();
    }

    public void cargarPersonal(String nombre, String apellido, int dni, int cuit, int tel, String email, String area, String turno) {
        Personal p = new Personal();
        p.setNombre(nombre);
        p.setApellido(apellido);
        p.setDni(dni);
        p.setCuit(cuit);
        p.setTelefono(tel);
        p.setEmail(email);
        p.setArea(area);
        p.setTurno(turno);
        ctrl.crearPersonal(p);
    }

    public void editarPersonal(Personal personal, String nombre, String apellido, int dni, int cuit, int tel, String email, String area, String turno) {
        personal.setNombre(nombre);
        personal.setApellido(apellido);
        personal.setDni(dni);
        personal.setCuit(cuit);
        personal.setTelefono(tel);
        personal.setEmail(email);
        personal.setArea(area);
        personal.setTurno(turno);
        ctrl.editarPersonal(personal);
    }

    public Tutor traerTutor(int idTutor) {
        return ctrl.traerTutor(idTutor);

    }

    public Personal traerPersonal(int idPersonal) {
        return ctrl.traerPersonal(idPersonal);
    }

}
