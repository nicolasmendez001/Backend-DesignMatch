package co.edu.uptc.sw2.desingmatch.tools;

import co.edu.uptc.sw2.desingmatch.persistence.DTO.DisenioDTO;
import co.edu.uptc.sw2.desingmatch.persistence.entities.Disenio;
import co.edu.uptc.sw2.desingmatch.servicios.logica.DisenioLogica;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.mail.MessagingException;

@Stateless
public class ProcesoBatch {

    @EJB
    private DisenioLogica disenioLogica;

    private static final String PATH = "C:\\img\\procesado";

    @Schedule(hour = "*", minute = "0/5", second = "0/20", persistent = false)
    public void searchImages() throws MessagingException {
        System.out.println(new Date().getSeconds() + " Voy a buscar imagenes sin procesar...");
        List<Disenio> diseniosSinProcesar = convertirListaDiseniosDTOaEntity(disenioLogica.buscarDisenosSinProcesar());
        for (Disenio disenoAProcesar : diseniosSinProcesar) {
            try {
                System.out.println("Encontre una foto sin procesar, es: " + disenoAProcesar);
                String rutaImagen = disenoAProcesar.getOriginalPath();
                String nombreArchivoImagen = new File(rutaImagen).getName();
                ImageManager.procesarImagen(rutaImagen, PATH + nombreArchivoImagen,
                        disenoAProcesar.getNombresDisenador() + " " + disenoAProcesar.getApellidosDisenador(),
                       disenoAProcesar.getFechaCreacion());
                disenoAProcesar.setEstado("DISPONIBLE");
                disenoAProcesar.setEditPath(PATH + nombreArchivoImagen);
                disenioLogica.updateDisenio(disenoAProcesar);
                
                //Send email
                
                ManagerCorreos.sendMail(ConstantesGlobales.MAILS_USER, ConstantesGlobales.MAILS_PASSWORD, 
                        disenoAProcesar.getEmailDisenador(), ConstantesGlobales.MAILS_SUBJECT, ConstantesGlobales.MAILS_MESSAGE);
                
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("Ya termine de buscar imagenes");
    }
    
     public List<Disenio> convertirListaDiseniosDTOaEntity(List<DisenioDTO> listaDiseniosDTO) {
        List<Disenio> listaDiseniosEntity = new ArrayList<>();
        for (DisenioDTO disenioDTO : listaDiseniosDTO) {
            listaDiseniosEntity.add(disenioDTO.convertirDisenioDTOaDisenioEntity());
        }
        return listaDiseniosEntity;
    }
}
