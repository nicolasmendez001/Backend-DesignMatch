/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.sw2.desingmatch.servicios;

import co.edu.uptc.sw2.desingmatch.persistence.DTO.DisenioDTO;
import co.edu.uptc.sw2.desingmatch.persistence.entities.Disenio;
import co.edu.uptc.sw2.desingmatch.servicios.logica.DisenioLogica;
import co.edu.uptc.sw2.desingmatch.tools.FilesManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("disenio")
public class DisenioServicio {

    @EJB
    private DisenioLogica logica;

    @POST
    @Path("addDisenio/{id}")
    public Disenio registrarDisenio(DisenioDTO disenio, @PathParam("id") int id) {
        return logica.addDisenio(disenio, id);
    }

    @POST
    @Path("loadDisenios")
    public List<DisenioDTO> loadDisenios(int idProyecto) {
        return logica.loadDisenio(idProyecto);
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
    public DisenioDTO editarDisenio(Disenio disenio) {
        System.out.println("Entra a editar");
        return logica.updateDisenio(disenio);
    }

    @GET
    public List<DisenioDTO> getList() {
        System.out.println("Entra a buscar");
        return logica.buscarDisenosSinProcesar();
    }

    @GET
    @Path("getImg")
    public List<String> getImg(@QueryParam("path") String path) throws IOException {
        System.out.println("Path img --> " + path);
        return FilesManager.imgToBase64(path);
    }
    @GET
    @Path("/getPath/{idproject}")
    public List<String> getPath(@PathParam("idproject") int id){
        return logica.getPath(id);
    }

    @GET
    @Path("/")
    @Produces({MediaType.TEXT_PLAIN})
    public Response index() {
        return Response
                .status(200)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Headers",
                        "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Methods",
                        "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .entity("")
                .build();
    }
}
