package co.edu.uptc.sw2.desingmatch.persistence.DTO;

import java.util.ArrayList;
import java.util.List;

public class EmpresaDTO {

    private int id;
    private String nombre;
    private String email;
    private String contrasena;
    private String url;
    private List<ProyectoDTO> proyectos;

    public EmpresaDTO() {
        this.proyectos = new ArrayList<>();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setProyectos(List<ProyectoDTO> proyectos) {
        this.proyectos = proyectos;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getUrl() {
        return url;
    }

    public List<ProyectoDTO> getProyectos() {
        return proyectos;
    }
}
