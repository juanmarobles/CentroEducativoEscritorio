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
public class ModeloAula {

    public ArrayList<Aula> getAulas() {
        Connection con = Conexion.getConexion();
        Statement stmt;
        ResultSet rs;
        ArrayList<Aula> listaAulas = new ArrayList<>();

        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM aula");

            while (rs.next()) {
                Aula aula = new Aula();
                aula.setAulaId(rs.getInt("AULAID")); 
                aula.setAula(rs.getString("AULA"));
                listaAulas.add(aula);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModeloAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaAulas;
    }
}
