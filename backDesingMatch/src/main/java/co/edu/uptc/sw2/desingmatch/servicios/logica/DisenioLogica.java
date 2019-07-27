/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.sw2.desingmatch.servicios.logica;

import co.edu.uptc.sw2.desingmatch.persistence.DTO.DisenioDTO;
import co.edu.uptc.sw2.desingmatch.persistence.DisenioDao;
import co.edu.uptc.sw2.desingmatch.persistence.entities.Disenio;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class DisenioLogica {

    @EJB
    private DisenioDao dao;

    public Disenio addDisenio(DisenioDTO disenio, int id) {
        return dao.addDisenio(convertirDTOaEntity(disenio), id);
    }

    public DisenioDTO updateDisenio(Disenio disenio) {
        return convertirEntityaDTO(dao.updateDisenio(disenio));
    }

    public List<DisenioDTO> buscarDisenosSinProcesar() {
        List l = new ArrayList();
        for (Disenio loadDisenio : dao.geDisenionSinPorcesar()) {
            l.add(convertirEntityaDTO(loadDisenio));
        }
        return l;
    }

    public List<DisenioDTO> loadDisenio(int idProyecto) {
        List l = new ArrayList();
        for (Disenio loadDisenio : dao.loadDisenios(idProyecto)) {
            if (loadDisenio.getEstado().equals("DISPONIBLE")) {
                l.add(convertirEntityaDTO(loadDisenio));
            }
        }
        return l;
    }

    //METODOS PARA CONVERTIR UN DISEÑO DE DTO A ENTITY Y VICEVERZA
    private Disenio convertirDTOaEntity(DisenioDTO disenioDTO) {
        System.out.println("Entra id diseño -> " + disenioDTO.getId());
        Disenio disenioEntity = new Disenio();
        disenioEntity.setId(disenioDTO.getId());
        disenioEntity.setNombresDisenador(disenioDTO.getNombresDisenador());
        disenioEntity.setApellidosDisenador(disenioDTO.getApellidosDisenador());
        disenioEntity.setEmailDisenador(disenioDTO.getEmailDisenador());
        disenioEntity.setEstado(disenioDTO.getEstado());
        disenioEntity.setOriginalPath(disenioDTO.getOriginalPath());
        disenioEntity.setEditPath(disenioDTO.getEditPath());
        disenioEntity.setCosto(disenioDTO.getCosto());
        disenioEntity.setFechaCreacion(disenioDTO.getFechaCreacion());
        return disenioEntity;
    }

    private DisenioDTO convertirEntityaDTO(Disenio disenioEntity) {
        DisenioDTO disenioDTO = new DisenioDTO();
        disenioDTO.setId(disenioEntity.getId());
        disenioDTO.setNombresDisenador(disenioEntity.getNombresDisenador());
        disenioDTO.setApellidosDisenador(disenioEntity.getApellidosDisenador());
        disenioDTO.setEmailDisenador(disenioEntity.getEmailDisenador());
        disenioDTO.setEstado(disenioEntity.getEstado());
        disenioDTO.setOriginalPath(disenioEntity.getOriginalPath());
        disenioDTO.setEditPath(disenioEntity.getEditPath());
        disenioDTO.setCosto(disenioEntity.getCosto());
        disenioDTO.setFechaCreacion(disenioEntity.getFechaCreacion());
        return disenioDTO;
    }

    public List<String> getPath(int id) {
        return dao.getPath(id);
    }
}
