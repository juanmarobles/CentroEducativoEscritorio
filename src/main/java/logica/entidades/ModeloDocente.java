/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Conexion;

/**
 *
 * @author juanmarobles
 */
public class ModeloDocente {

    public List<Docente> getDocentes() {
        Connection con = Conexion.getConexion();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Docente> listaDocentes = new ArrayList<>();

        try {
            String sql = "SELECT ID, NOMBRE, APELLIDO FROM usuario WHERE DTYPE = 'Docente'";
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Docente docente = new Docente();
                docente.setId(rs.getInt("ID"));
                docente.setNombre(rs.getString("NOMBRE"));
                docente.setApellido(rs.getString("APELLIDO"));
                listaDocentes.add(docente);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModeloDocente.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                // Manejar excepciones aquí
            }
        }
        return listaDocentes;
    }
}
