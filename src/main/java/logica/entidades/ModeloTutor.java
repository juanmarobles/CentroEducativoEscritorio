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
public class ModeloTutor {

    public ArrayList<Tutor> getTutores() {
        Connection con = Conexion.getConexion();

        Statement stmt;
        ResultSet rs;
        ArrayList<Tutor> listaTutores = new ArrayList<>();

        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM tutor");

            while (rs.next()) {
                Tutor tutor = new Tutor();
                tutor.setId(rs.getInt("ID"));
                tutor.setNombre(rs.getString("NOMBRE"));
                tutor.setApellido(rs.getString("APELLIDO"));
                tutor.setDni(rs.getInt("DNI"));
                tutor.setEmail(rs.getString("EMAIL"));
                tutor.setDomicilio(rs.getString("DOMICILIO"));
                tutor.setTelefono(rs.getInt("TELEFONO"));

                listaTutores.add(tutor);

            }
        } catch (SQLException ex) {
            Logger.getLogger(ModeloTutor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaTutores;
    }
}
