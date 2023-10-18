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
public class ModeloMateria {

    public ArrayList<Materia> getMaterias(){       
        Connection con = Conexion.getConexion();
        
        Statement stmt;
        ResultSet rs;
        ArrayList<Materia> listaMateria = new ArrayList<>();
        
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM materias");
            
            while(rs.next()){
                Materia cl = new Materia();
                cl.setIdMateria(rs.getInt("IDMATERIA"));
                cl.setMateria(rs.getString("MATERIA"));
                listaMateria.add(cl);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModeloMateria.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaMateria;
    }
}
