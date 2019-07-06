package co.edu.uptc.sw2.desingmatch.servicios;

import co.edu.uptc.sw2.desingmatch.persistence.entities.Proyecto;
import co.edu.uptc.sw2.desingmatch.servicios.logica.ProyectoLogica;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("Proyectos")
@Stateless
public class ProyectoServicio {

    @EJB
    private ProyectoLogica proyectoLogica;

    @POST
    @Path("registrarProyecto/{idEmpresa}")
    public Proyecto registrarProyecto(Proyecto proyecto, @PathParam("idEmpresa") int id) {
        return proyectoLogica.registarProyecto(proyecto, id);
    }

    @DELETE
    @Path("/{idEmpresa}/{idProyect}")
    public void eliminarProyecto(@PathParam("idEmpresa") int idEmpresa, @PathParam("idProyect") int idProyect) {
        System.out.println("Entra a eliminar");
        proyectoLogica.eliminarProyecto(idEmpresa, idProyect);
    }

    @PUT
    @Path("editarProyecto")
    public Proyecto editarProyecto(Proyecto proyecto) {
        return proyectoLogica.editarProyecto(proyecto);
    }

    @GET
    @Path("/{url}")
    public List<Proyecto> getListaProyectos(@PathParam("url") String url) {
        System.out.println("entra --> " + url);
        return proyectoLogica.getListaProyectos(url);
    }
}
