package co.edu.uptc.sw2.desingmatch.tools;

import co.edu.uptc.sw2.desingmatch.persistence.entities.Disenio;
import co.edu.uptc.sw2.desingmatch.servicios.logica.DisenioLogica;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Stateless;

@Stateless
public class ProcesoBatch {

    @EJB
    private DisenioLogica disenioLogica;

    private static final String PATH = "C:\\img\\procesado";

    @Schedule(hour = "*", minute = "*", second = "0/20", persistent = false)
    public void searchImages() {
        System.out.println(new Date().getSeconds() + " Voy a buscar imagenes sin procesar...");
        List<Disenio> diseniosSinProcesar = disenioLogica.buscarDisenosSinProcesar();
        for (Disenio disenoAProcesar : diseniosSinProcesar) {
            try {
                System.out.println("Encontre una foto sin procesar, es: " + disenoAProcesar);
                String rutaImagen = disenoAProcesar.getRutaImagen();
                String nombreArchivoImagen = new File(rutaImagen).getName();
                ImageManager.procesarImagen(rutaImagen, PATH + nombreArchivoImagen,
                        disenoAProcesar.getNombresDisenador() + " " + disenoAProcesar.getApellidosDisenador(),
                       disenoAProcesar.getFechaCreacion());
                disenoAProcesar.setEstado("DISPONIBLE");
                disenoAProcesar.setRutaImagen(PATH + nombreArchivoImagen);
                disenioLogica.updateDisenio(disenoAProcesar);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("Ya termine de buscar imagenes");
    }
}
