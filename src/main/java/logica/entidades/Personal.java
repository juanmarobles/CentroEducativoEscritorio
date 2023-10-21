/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.entidades;

import javax.persistence.Entity;


/**
 *
 * @author juanmarobles
 */
@Entity
public class Personal extends Usuario {
  private int cuit;
  private String area;
  private String turno;

    public Personal() {
    }

    public Personal(int cuit, String area, String turno, int id, String usuario, String contrasena, String nombre, String apellido, int dni, int telefono, String domicilio, String email, String rol) {
        super(id, usuario, contrasena, nombre, apellido, dni, telefono, domicilio, email, rol);
        this.cuit = cuit;
        this.area = area;
        this.turno = turno;
    }

    public int getCuit() {
        return cuit;
    }

    public void setCuit(int cuit) {
        this.cuit = cuit;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

  
    
}
