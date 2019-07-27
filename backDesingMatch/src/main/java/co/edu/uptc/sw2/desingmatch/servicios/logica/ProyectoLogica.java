package co.edu.uptc.sw2.desingmatch.servicios.logica;

import co.edu.uptc.sw2.desingmatch.persistence.DTO.DisenioDTO;
import co.edu.uptc.sw2.desingmatch.persistence.DTO.ProyectoDTO;
import co.edu.uptc.sw2.desingmatch.persistence.ProyectoDao;
import co.edu.uptc.sw2.desingmatch.persistence.entities.Disenio;
import co.edu.uptc.sw2.desingmatch.persistence.entities.Proyecto;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class ProyectoLogica {

    @EJB
    private ProyectoDao proyectoDao;

    public Proyecto registarProyecto(Proyecto proyecto, int id) {
        return proyectoDao.registrarProyecto(proyecto, id);
    }

    public String eliminarProyecto(int idEmpresa, int idProyecto) {
        return proyectoDao.eliminarProyecto(idEmpresa, idProyecto);
    }

    public ProyectoDTO editarProyecto(ProyectoDTO proyecto) {
        return convertirProyectoEntityaDTO(proyectoDao.editarProyecto(convertirProyectoDTOaEntity(proyecto)));
    }

    public Proyecto buscarProyecto(int id) {
        return proyectoDao.buscarProyecto(id);
    }

    public List<ProyectoDTO> getListaProyectos(String url) {
        return convertirListaProyectosEntityaDTO(proyectoDao.getListaProyectos(url));
    }

    //METODOS PARA CONVERTIR UN PROYECTO/LISTA DE PROYECTOS DE DTO A ENTITY Y VICEVERZA
    public Proyecto convertirProyectoDTOaEntity(ProyectoDTO proyectoDTO) {
        System.out.println("Id a buscar --> " + proyectoDTO.getIdProyecto());
        Proyecto proyectoEntity = new Proyecto();
        proyectoEntity.setIdProyecto(proyectoDTO.getIdProyecto());
        proyectoEntity.setNombre(proyectoDTO.getNombre());
        proyectoEntity.setDescripcion(proyectoDTO.getDescripcion());
        proyectoEntity.setValor(proyectoDTO.getValor());
        proyectoEntity.setDisenios(convertirListaDiseniosDTOaEntity(proyectoDTO.getDisenios()));
        return proyectoEntity;
    }

    public List<Disenio> convertirListaDiseniosDTOaEntity(List<DisenioDTO> listaDiseniosDTO) {
        List<Disenio> listaDiseniosEntity = new ArrayList<>();
        for (DisenioDTO disenioDTO : listaDiseniosDTO) {
            listaDiseniosEntity.add(disenioDTO.convertirDisenioDTOaDisenioEntity());
        }
        return listaDiseniosEntity;
    }

    public ProyectoDTO convertirProyectoEntityaDTO(Proyecto proyectoEntity) {
        ProyectoDTO proyectoDTO = new ProyectoDTO();
        proyectoDTO.setIdProyecto(proyectoEntity.getIdProyecto());
        proyectoDTO.setNombre(proyectoEntity.getNombre());
        proyectoDTO.setDescripcion(proyectoEntity.getDescripcion());
        proyectoDTO.setValor(proyectoEntity.getValor());
        proyectoDTO.setDisenios(convertirListaDiseniosEntityaDTO(proyectoEntity.getDisenios()));
        return proyectoDTO;
    }

    public List<DisenioDTO> convertirListaDiseniosEntityaDTO(List<Disenio> diseniosEntity) {
        List<DisenioDTO> convertidosADTO = new ArrayList<>();
        for (Disenio disenioEntity : diseniosEntity) {
            DisenioDTO disenioDTO = new DisenioDTO();
            disenioDTO.setNombresDisenador(disenioEntity.getNombresDisenador());
            disenioDTO.setApellidosDisenador(disenioEntity.getApellidosDisenador());
            disenioDTO.setEmailDisenador(disenioEntity.getEmailDisenador());
            disenioDTO.setEstado(disenioEntity.getEstado());
            disenioDTO.setOriginalPath(disenioEntity.getOriginalPath());
            disenioDTO.setEditPath(disenioEntity.getEditPath());
            disenioDTO.setCosto(disenioEntity.getCosto());
            convertidosADTO.add(disenioDTO);
        }
        return convertidosADTO;
    }

    public List<ProyectoDTO> convertirListaProyectosEntityaDTO(List<Proyecto> listaProyectosEntity) {
        List<ProyectoDTO> listaProyectosDTO = new ArrayList<>();
        for (Proyecto proyectoEntity : listaProyectosEntity) {
            listaProyectosDTO.add(convertirProyectoEntityaDTO(proyectoEntity));
        }
        return listaProyectosDTO;
    }

    public List<Proyecto> convertirListaProyectosDTOaEntity(List<ProyectoDTO> listaProyectosDTO) {
        List<Proyecto> listaProyectosEntity = new ArrayList<>();
        for (ProyectoDTO proyectoDTO : listaProyectosDTO) {
            listaProyectosEntity.add(convertirProyectoDTOaEntity(proyectoDTO));
        }
        return listaProyectosEntity;
    }
}
