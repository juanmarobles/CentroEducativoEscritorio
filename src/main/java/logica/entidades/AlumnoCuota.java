/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.entidades;

import java.io.Serializable;
import javax.persistence.*;
import javax.persistence.ManyToOne;

/**
 *
 * @author juanmarobles
 */
@Entity
public class AlumnoCuota implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "alumno_id")
    private Alumno alumno;

    @ManyToOne
    @JoinColumn(name = "cuota_id")
    private Cuota cuota;

    private int mes;

    private boolean pagado;

    public AlumnoCuota() {
    }

    public AlumnoCuota(int id, Alumno alumno, Cuota cuota, int mes, boolean pagado) {
        this.id = id;
        this.alumno = alumno;
        this.cuota = cuota;
        this.mes = mes;
        this.pagado = pagado;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Cuota getCuota() {
        return cuota;
    }

    public void setCuota(Cuota cuota) {
        this.cuota = cuota;
    }

    public boolean isPagado() {
        return pagado;
    }

    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }

}
