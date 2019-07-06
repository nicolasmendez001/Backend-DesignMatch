package co.edu.uptc.sw2.desingmatch.servicios;

import co.edu.uptc.sw2.desingmatch.persistence.entities.Empresa;
import co.edu.uptc.sw2.desingmatch.servicios.logica.EmpresaLogica;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("empresa")
public class EmpresaServicio {
    
    @EJB
    private EmpresaLogica logica;
    
    @POST
    @Path("registrarEmpresa")
    public Empresa saveEmpresa(Empresa empresa){
        System.out.println("Entra: " + empresa.getNombre());
        return logica.saveEmpresa(empresa);
    }
    
      @GET
    @Path("/login/{email}/{password}")
    public Empresa login(@PathParam("email") String email, @PathParam("password") String password) {
        System.out.println("entra: " + email + "--- " + password);
        return logica.loginEmpresa(email, password);
    }
}