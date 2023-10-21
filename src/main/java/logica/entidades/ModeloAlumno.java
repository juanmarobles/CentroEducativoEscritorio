/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package logica.entidades;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Conexion;
/**
 *
 * @author juanmarobles
 */
public class ModeloAlumno {

    public ArrayList<Alumno> getAlumnos() {       
        Connection con = Conexion.getConexion();
        Statement stmt;
        ResultSet rs;
        ArrayList<Alumno> listaAlumnos = new ArrayList<>();
        
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM usuario");
            
            while (rs.next()) {
                Alumno alumno = new Alumno();
                alumno.setId(rs.getInt("id")); // Ajusta según la estructura de tu tabla
                alumno.setNombre(rs.getString("NOMBRE"));
                alumno.setApellido(rs.getString("APELLIDO"));
                // Asigna otros atributos del alumno si los tienes en tu base de datos
                listaAlumnos.add(alumno);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModeloAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaAlumnos;
    }
}
