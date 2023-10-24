/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author juanmarobles
 */
@Entity
public class Autoridad extends Usuario implements Serializable {

    public Autoridad(int id, String usuario, String contrasena, String nombre, String apellido, int dni, int telefono, String domicilio, String email, String rol, Docente docente, Alumno alumno, Tutor tutor, Personal personal) {
        super(id, usuario, contrasena, nombre, apellido, dni, telefono, domicilio, email, rol, docente, alumno, tutor, personal);
    }

    
   
    public Autoridad() {
    }

}
