package co.edu.uptc.sw2.desingmatch.servicios;

import co.edu.uptc.sw2.desingmatch.persistence.DTO.EmpresaDTO;
import co.edu.uptc.sw2.desingmatch.persistence.entities.Empresa;
import co.edu.uptc.sw2.desingmatch.servicios.logica.EmpresaLogica;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("empresa")
public class EmpresaServicio {

    @EJB
    private EmpresaLogica logica;

    @POST
    @Path("registrarEmpresa")
    public EmpresaDTO saveEmpresa(EmpresaDTO empresa) {
        System.out.println("EMpresa --> "+ empresa.getNombre() + empresa.getEmail());
        return logica.saveEmpresa(empresa);
    }

    @GET
    @Path("/login/{email}/{password}")
    public EmpresaDTO login(@PathParam("email") String email, @PathParam("password") String password) {
        System.out.println("entra: " + email + "--- " + password);
        return logica.loginEmpresa(email, password);
    }

    @POST
    @Path("validateName")
    public Object validateName(String name) {
        System.out.println("Name -> " + name);
        return logica.validateName(name);
    }
}
