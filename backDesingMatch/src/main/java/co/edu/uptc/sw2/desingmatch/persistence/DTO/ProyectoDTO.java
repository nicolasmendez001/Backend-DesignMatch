package co.edu.uptc.sw2.desingmatch.persistence.DTO;

import java.util.List;

public class ProyectoDTO {

    private int idProyecto;
    private String nombre;
    private String descripcion;
    private double valor;
    private List<DisenioDTO> disenios;

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setDisenios(List<DisenioDTO> disenios) {
        this.disenios = disenios;
    }

    public List<DisenioDTO> getDisenios() {
        return disenios;
    }
}
