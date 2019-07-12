/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.sw2.desingmatch.servicios;

import co.edu.uptc.sw2.desingmatch.persistence.entities.Disenio;
import co.edu.uptc.sw2.desingmatch.servicios.logica.DisenioLogica;
import co.edu.uptc.sw2.desingmatch.tools.FilesManager;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("disenio")
public class DisenioServicio {

    @EJB
    private DisenioLogica logica;

    @POST
    @Path("addDisenio/{id}")
    public Disenio registrarDisenio(Disenio disenio, @PathParam("id") int id) {
        System.out.println("Entra a añadir --> " );
        System.out.println("Nombre --> " + disenio.getNombresDisenador());
        System.out.println("Id p --> " + id);
        return logica.addDisenio(disenio, id);
    }

    @POST
    @Path("saveImg/{nameImg}")
    public List<String> saveImg(String img, @PathParam("nameImg") String nameImg) {
        List<String> l = new ArrayList<>();
         l.add(FilesManager.guardarImagenEnDisco(img, nameImg));
         return l;
    }
    
    @PUT
    @Path("update")
    public Disenio editarDisenio(Disenio disenio) {
        System.out.println("Entra a editar");
        return logica.updateDisenio(disenio);
    }
}
