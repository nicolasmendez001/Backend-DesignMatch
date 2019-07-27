package co.edu.uptc.sw2.desingmatch.servicios.logica;

import co.edu.uptc.sw2.desingmatch.persistence.DTO.EmpresaDTO;
import co.edu.uptc.sw2.desingmatch.persistence.EmpresaDao;
import co.edu.uptc.sw2.desingmatch.persistence.entities.Empresa;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class EmpresaLogica {

    @EJB
    private EmpresaDao dao;

    @EJB
    private ProyectoLogica proyectoLogica;

    public EmpresaDTO saveEmpresa(EmpresaDTO empresa) {
        return convertirEntityaDTO(dao.saveEmpresa(convertirDTOaEntity(empresa)));
    }

    public EmpresaDTO loginEmpresa(String email, String password) {
        return convertirEntityaDTO(dao.loginEmpresa(email, password));
    }

    public Object validateName(String name) {
        return dao.validateName(name);
    }

    //METODOS PARA CONVERTIR UNA EMPRESA/LISTA DE EMPRESAS DE DTO A ENTITY Y VICEVERZA
    private Empresa convertirDTOaEntity(EmpresaDTO empresaDTO) {
        Empresa empresaEntity = new Empresa();
        empresaEntity.setNombre(empresaDTO.getNombre());
        empresaEntity.setContrasena(empresaDTO.getContrasena());
        empresaEntity.setEmail(empresaDTO.getEmail());
        empresaEntity.setProyectos(proyectoLogica.convertirListaProyectosDTOaEntity(empresaDTO.getProyectos()));
        empresaEntity.setUrl(empresaDTO.getUrl());
        return empresaEntity;
    }

    private EmpresaDTO convertirEntityaDTO(Empresa empresaEntity) {
        EmpresaDTO empresaDTO = new EmpresaDTO();
        empresaDTO.setId(empresaEntity.getId());
        empresaDTO.setNombre(empresaEntity.getNombre());
        empresaDTO.setContrasena(empresaEntity.getContrasena());
        empresaDTO.setEmail(empresaEntity.getContrasena());
        empresaDTO.setProyectos(proyectoLogica.convertirListaProyectosEntityaDTO(empresaEntity.getProyectos()));
        empresaDTO.setUrl(empresaEntity.getUrl());
        return empresaDTO;
    }
}
