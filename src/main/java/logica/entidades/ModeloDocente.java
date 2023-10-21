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

    public ArrayList<Docente> getDocentes() {
        Connection con = Conexion.getConexion();

        Statement stmt;
        ResultSet rs;
        ArrayList<Docente> listaDocentes = new ArrayList<>();

        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM usuario");

            while (rs.next()) {
                Docente docente = new Docente();
                docente.setId(rs.getInt("IDPERSONA"));
                docente.setNombre(rs.getString("NOMBRE"));
                docente.setApellido(rs.getString("APELLIDO"));
                docente.setDni(rs.getInt("DNI"));
                docente.setEmail(rs.getString("EMAIL"));
                docente.setDomicilio(rs.getString("DOMICILIO"));
                docente.setTelefono(rs.getInt("TELEFONO"));
                docente.setNivel(rs.getString("NIVEL"));
                docente.setTurno(rs.getString("TURNO"));

                List<Materia> materiasDocente = obtenerMateriasDocente(docente.getId());
                docente.setMaterias(materiasDocente);

                listaDocentes.add(docente);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModeloDocente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaDocentes;
    }

    public List<Materia> obtenerMateriasDocente(int idDocente) {
        Connection con = Conexion.getConexion();
        List<Materia> materias = new ArrayList<>();
        String sql = "SELECT m.* FROM docente_materia dm "
                + "JOIN materias m ON dm.materia_id = m.idMateria "
                + "WHERE dm.docente_id = " + idDocente;

        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Materia materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setAula(rs.getString("aula"));
                materia.setDia(rs.getString("dia"));
                materia.setDesde(rs.getString("desde"));
                materia.setHasta(rs.getString("hasta"));
                materia.setMateria(rs.getString("materia"));
                // Otras propiedades de la entidad Materia si las tienes
                materias.add(materia);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones
        }

        return materias;
    }

}
