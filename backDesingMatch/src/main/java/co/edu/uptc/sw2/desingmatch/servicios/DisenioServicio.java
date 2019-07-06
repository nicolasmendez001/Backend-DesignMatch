/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.sw2.desingmatch.servicios;

import co.edu.uptc.sw2.desingmatch.persistence.entities.Disenio;
import co.edu.uptc.sw2.desingmatch.servicios.logica.DisenioLogica;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("disenio")
@Stateless
public class DisenioServicio {
    
    private DisenioLogica logica;
    
    @GET
    public String getDisenios(){
        return "Hello";
    }
    
    @POST
    @Path("addDisenio/{project}")
    public String registrarDisenio(Disenio disenio, @PathParam("project") int project) {
        System.out.println("Entra a añadir");
        return logica.addDisenio(disenio, project);
    }
}
