/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import igu.mprincipal.MenuPrincipalAlumno;
import igu.mprincipal.MenuPrincipalAutoridad;
import igu.mprincipal.MenuPrincipalDocente;
import igu.mprincipal.MenuPrincipalPersonal;
import igu.mprincipal.MenuPrincipalTutor;
import java.util.Date;
import java.util.List;
import logica.entidades.Alumno;
import logica.entidades.AlumnoCuota;
import logica.entidades.Aula;
import logica.entidades.Cuota;
import logica.entidades.Docente;
import logica.entidades.DocenteMateria;
import logica.entidades.Materia;
import logica.entidades.Nota;
import logica.entidades.Personal;
import logica.entidades.Tutor;
import logica.entidades.TutorAlumno;
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
    public Usuario validarUsuario(String usuario, String password) {
        List<Usuario> usuarios = ctrl.traerUsuarios(usuario, password);

        for (Usuario usu : usuarios) {
            if (usu.getUsuario().equals(usuario) && usu.getContrasena().equals(password)) {
                // La autenticación es exitosa
                return usu;
            }
        }

        // La autenticación falló
        return null;
    }

    

    public void crearUsuario(String nombre, String apellido, String usuario, String contrasena, String rol) {
        Usuario u = new Usuario();
        u.setNombre(nombre);
        u.setApellido(apellido);
        u.setUsuario(usuario);
        u.setContrasena(contrasena);
        u.setRol(rol);

        // Crear un objeto de entidad correspondiente al rol
        if ("Docente".equals(rol)) {
            Docente docente = new Docente();
            docente.setNombre(nombre);
            docente.setApellido(apellido);
            // Configurar otras propiedades específicas de Docente
            u.setDocente(docente);
            ctrl.crearDocente(docente);
        } else if ("Alumno".equals(rol)) {
            Alumno alumno = new Alumno();
            alumno.setNombre(nombre);
            alumno.setApellido(apellido);
            // Configura otras propiedades específicas de Alumno
            u.setAlumno(alumno);

            // Crear el alumno
            ctrl.guardarAlumno(alumno);

            // Crear las cuotas para el alumno
            for (int mes = 1; mes <= 12; mes++) {
                Cuota cuota = new Cuota();
                cuota.setAlumno(alumno);
                cuota.setMonto(0.0); // Establece el monto (ajusta según tus requisitos)
                cuota.setMes(mes);
                if (mes == 1) {
                    cuota.setPagado(false); // Establece "pagado" en false solo para el mes 1
                } else {
                    cuota.setPagado(true); // Establece "pagado" en true para los demás meses
                } // Establece "pagado" en falso
                cuota.setFechaPago(null); // Puedes establecer la fecha de pago como nula o a una fecha por defecto
                // Guarda la cuota
                ctrl.guardarCuota(cuota);
            }

        } else if ("Tutor".equals(rol)) {
            Tutor tutor = new Tutor();
            tutor.setNombre(nombre);
            tutor.setApellido(apellido);
            // Configurar otras propiedades específicas de Tutor
            u.setTutor(tutor);
            ctrl.guardarTutor(tutor);
        } else if ("Personal".equals(rol)) {
            Personal personal = new Personal();
            personal.setNombre(nombre);
            personal.setApellido(apellido);
            // Configurar otras propiedades específicas de Personal
            u.setPersonal(personal);
            ctrl.crearPersonal(personal);
        }

        ctrl.crearUsuario(u);
    }


    /* ------------------------------------CRUD ALUMNOS--------------------------------------------------------*/
    public void borrarAlumno(int idAlumno) {
        ctrl.borrarAlumno(idAlumno);
    }

    public List<Alumno> traerAlumnos() {
        return ctrl.traerAlumnos();
    }

    public void cargarAlumno(String nombre, String apellido, int dni, int idTutor, String nivel, String division, String fecha) {
        Tutor tutor = ctrl.traerTutorPorId(idTutor);

        Alumno alumno = new Alumno();
        alumno.setNombre(nombre);
        alumno.setApellido(apellido);
        alumno.setDni(dni);
        //alumno.setTutor(tutor);
        alumno.setNivel(nivel);
        alumno.setDivision(division);
        alumno.setFechaNac(fecha);
        alumno.setRol("Alumno");

        TutorAlumno tutorAlumno = new TutorAlumno();
        tutorAlumno.setAlumno(alumno);
        tutorAlumno.setTutor(tutor);

        // Agrega el tutorAlumno a las listas de tutor y alumno
        tutor.getTutorAlumnos().add(tutorAlumno);
        alumno.setTutor(tutor);

        ctrl.guardarAlumno(alumno);
        ctrl.actualizarTutor(tutor);
        ctrl.actualizarTutorAlumno(tutorAlumno);
    }

    public void editarAlumno(Alumno alumno, String nombre, String apellido, int dni, String fecha, String nivel, String division, String fecha2) {
        alumno.setNombre(nombre);
        alumno.setApellido(apellido);
        alumno.setDni(dni);
        alumno.setNivel(nivel);
        alumno.setDivision(division);
        alumno.setFechaNac(fecha);
        alumno.setRol("Alumno");
        ctrl.editarAlumno(alumno);
    }

    public Alumno traerAlumno(int idAlumno) {
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
        tutor.setRol("Tutor");
        ctrl.guardarTutor(tutor);
    }

    public void editarTutor(Tutor tutor, String nombre, String apellido, int dni, String domicilio, String email, String telefono) {
        tutor.setNombre(nombre);
        tutor.setApellido(apellido);
        tutor.setDni(dni);
        tutor.setDomicilio(domicilio);
        tutor.setEmail(email);
        tutor.setTelefono(dni);
        tutor.setRol("Tutor");
        ctrl.EditarTutor(tutor);
    }

    public void borrarTutor(int idTutor) {
        ctrl.borrarTutor(idTutor);
    }

    public List<Tutor> traerTutores() {
        return ctrl.traerTutores();
    }

    /* ------------------------------------CRUD DOCENTES--------------------------------------------------------*/
    public List<Docente> traerDocentes() {
        return ctrl.traerDocentes();
    }

    public void cargarDocente(String nombre, String apellido, int dni, String domicilio, String tel, String email) {
        Docente d = new Docente();
        d.setNombre(nombre);
        d.setApellido(apellido);
        d.setDni(dni);
        d.setDomicilio(domicilio);
        d.setTelefono(dni);
        d.setEmail(email);
        d.setRol("Docente");
        ctrl.crearDocente(d);
    }

    public void editarDocente(Docente docente, String nombre, String apellido, int dni, String domicilio, int telefono, String email) {
        docente.setNombre(nombre);
        docente.setApellido(apellido);
        docente.setDni(dni);
        docente.setDomicilio(domicilio);
        docente.setTelefono(telefono);
        docente.setEmail(email);
        docente.setRol("Docente");
        ctrl.editarDocente(docente);
    }

    public Docente traerDocente(int idDocente) {
        return ctrl.traerDocente(idDocente);
    }

    public void borrarDocente(int idDocente) {
        ctrl.borrarDocente(idDocente);
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
        p.setRol("Personal");
        ctrl.crearPersonal(p);
    }

    public void editarPersonal(Personal personal, String nombre, String apellido, int dni, int cuit, int tel, String email, String area, String turno) {
        personal.setNombre(nombre);
        personal.setApellido(apellido);
        personal.setDni(dni);
        personal.setCuit(cuit);
        personal.setTelefono(tel);
        personal.setEmail(email);
        personal.setRol("Personal");
        ctrl.editarPersonal(personal);
    }

    public Tutor traerTutor(int idTutor) {
        return ctrl.traerTutor(idTutor);

    }

    public Personal traerPersonal(int idPersonal) {
        return ctrl.traerPersonal(idPersonal);
    }

    /* ------------------------------------CRUD MATERIAS--------------------------------------------------------*/
    public void asignarMateriaDocente(int idMateria, String dia, String desde, String hasta, int idDocente, Aula aula) {
        Materia materia = ctrl.traerMateriaPorId(idMateria);
        Docente docente = ctrl.traerDocentePorId(idDocente);

        if (materia != null && docente != null) {
            // Crear una instancia de AsignacionDocenteMateria y establecer los detalles
            DocenteMateria asignacion = new DocenteMateria();
            asignacion.setDia(dia);
            asignacion.setDesde(desde);
            asignacion.setHasta(hasta);
            asignacion.setDocente(docente);
            asignacion.setMateria(materia);
            asignacion.setAula(aula);

            // Agregar la asignación a las colecciones correspondientes
            docente.getMaterias().add(materia);
            materia.setDocente(docente);

            // Guardar los cambios
            ctrl.actualizarDocente(docente);
            ctrl.actualizarMateria(materia);
            ctrl.actualizarDocenteMateria(asignacion);
        }
    }

    public List<Materia> traerMaterias() {
        return ctrl.traerMaterias();
    }

    public void asignarMateriaAlumno(int idAlumno, int idMateria) {
        // Obtén la materia y el alumno correspondientes a los IDs proporcionados
        Materia materia = ctrl.traerMateriaPorId(idMateria);
        Alumno alumno = ctrl.traerAlumnoPorId(idAlumno);

        if (materia != null && alumno != null) {
            // Asigna la materia al alumno
            alumno.getMaterias().add(materia);

            // Obtén el aula de la materia y asígnala al alumno
            Aula aula = materia.getAula();
            if (aula != null) {
                alumno.setAula(aula);
            } else {
                // Aquí puedes manejar el caso en el que la materia no tiene un aula asignada
            }

            // Guarda los cambios
            ctrl.actualizarAlumno(alumno);
        }
    }

    public void asignarNotaAlumno(Materia materia, Alumno alumno, int nota) {
        Nota notaAlumno = new Nota();
        notaAlumno.setAlumno(alumno);
        notaAlumno.setMateria(materia);
        notaAlumno.setValor(nota);
        ctrl.asignarNotaAlumno(notaAlumno);
    }

    public void crearMateria(String nombre, Aula aula, String dia, String desde, String hasta) {
        Materia m = new Materia();
        m.setMateria(nombre);
        m.setAula(aula);
        m.setDia(dia);
        m.setDesde(desde);
        m.setHasta(hasta);
        ctrl.asignarMateriaNueva(m);
    }

    public void borrarMateria(int idMateria) {
        ctrl.eliminarMateria(idMateria);
    }

    public Alumno traerAlumnoPorId(int idAlumno) {
        return ctrl.traerAlumno(idAlumno);
    }

    public List<Nota> traerNotas() {
        return ctrl.traerNotas();
    }

    public List<Nota> traerNotasPorAlumno(Alumno alumnoSeleccionado) {
        return ctrl.traerNotasPorAlumno(alumnoSeleccionado);
    }

    public List<Aula> traerAulas() {
        return ctrl.traerAulas();
    }

    public List<Alumno> traerAlumnosPorAula(Aula aulaSeleccionado) {
        return ctrl.findAlumnosPorAula(aulaSeleccionado);
    }

    public List<Materia> traerMateriasPorDocente(Docente docSeleccionado) {
        return ctrl.findMateriasPorDocente(docSeleccionado);
    }

    public void asignarPagoAlumno(int idAlumno, int mes, Double monto) {
        Alumno alumno = ctrl.traerAlumnoPorId(idAlumno);

        if (alumno != null) {
            // Busca la cuota correspondiente al mes
            Cuota cuotaExistente = null;
            List<Cuota> cuotasDelAlumno = ctrl.traerCuotasDeAlumno(alumno);
            for (Cuota cuota : cuotasDelAlumno) {
                if (cuota.getMes() == mes) {
                    cuotaExistente = cuota;
                    break; // Encontramos la cuota, salimos del bucle
                }
            }

            if (cuotaExistente != null) {
                // Verifica si la cuota ya está pagada
                if (cuotaExistente.getPagado()) {
                    // Lanza una excepción o maneja la situación, ya está pagada
                    return;
                }

                // Actualiza la cuota existente con el nuevo monto y marca como pagado
                cuotaExistente.setMonto(monto);
                cuotaExistente.setPagado(true);

                // Actualiza la cuota en la base de datos
                ctrl.actualizarCuota(cuotaExistente);

                // Luego, crea una instancia de AlumnoCuota y establece los detalles
                AlumnoCuota asignacion = new AlumnoCuota();
                asignacion.setMes(mes);
                asignacion.setAlumno(alumno);
                asignacion.setCuota(cuotaExistente);
                asignacion.setPagado(true); // Marca como pagado

                // Actualiza la relación entre el alumno y la cuota
                ctrl.actualizarAlumnoCuota(asignacion);
            }
        }
    }

    public List<Cuota> traerCuotas() {
        return ctrl.traerCuotas();
    }
    /*
    public List<Alumno> obtenerAlumnosAsignadosAlDocente(String nombreUsuario) {
        return ctrl.obtenerAlumnosAsignadosAlDocente(nombreUsuario);
    }
     */

    public List<Alumno> obtenerAlumnosAsignadosPorId(int idUsuario) {
        return ctrl.obtenerAlumnosPorDocente(idUsuario);
    }

}
