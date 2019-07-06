/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.sw2.desingmatch.persistence.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Disenio implements Serializable {
     @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String emailDisenador;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    private String nombresDisenador;
    private String apellidosDisenador;
    private String estado;

    public void setId(int id) {
        this.id = id;
    }

    public void setEmailDisenador(String emailDisenador) {
        this.emailDisenador = emailDisenador;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setNombresDisenador(String nombresDisenador) {
        this.nombresDisenador = nombresDisenador;
    }

    public void setApellidosDisenador(String apellidosDisenador) {
        this.apellidosDisenador = apellidosDisenador;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public String getEmailDisenador() {
        return emailDisenador;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public String getNombresDisenador() {
        return nombresDisenador;
    }

    public String getApellidosDisenador() {
        return apellidosDisenador;
    }

    public String getEstado() {
        return estado;
    }
}
