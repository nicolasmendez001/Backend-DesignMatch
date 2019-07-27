/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.sw2.desingmatch.persistence.DTO;

import co.edu.uptc.sw2.desingmatch.persistence.entities.Disenio;

public class DisenioDTO {

    private int id;
    private String emailDisenador;
    private String fechaCreacion;
    private String nombresDisenador;
    private String apellidosDisenador;
    //ESTADO: EN_PROCESO, DISPONIBLE
    private String estado;
    private double costo;
    private String originalPath;
    private String editPath;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEditPath() {
        return editPath;
    }

    public String getOriginalPath() {
        return originalPath;
    }

    public void setEditPath(String editPath) {
        this.editPath = editPath;
    }

    public void setOriginalPath(String originalPath) {
        this.originalPath = originalPath;
    }
    
    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public void setEmailDisenador(String emailDisenador) {
        this.emailDisenador = emailDisenador;
    }

    public void setFechaCreacion(String fechaCreacion) {
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

    public String getEmailDisenador() {
        return emailDisenador;
    }

    public String getFechaCreacion() {
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

    public Disenio convertirDisenioDTOaDisenioEntity() {
        Disenio disenio = new Disenio();
        disenio.setId(id);
        disenio.setNombresDisenador(nombresDisenador);
        disenio.setApellidosDisenador(apellidosDisenador);
        disenio.setEmailDisenador(emailDisenador);
        disenio.setFechaCreacion(fechaCreacion);
        disenio.setEstado(estado);
        disenio.setOriginalPath(originalPath);
        disenio.setEditPath(editPath);
        disenio.setCosto(costo);
        return disenio;
    }
}
