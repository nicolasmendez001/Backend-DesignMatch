package co.edu.uptc.sw2.desingmatch.servicios.logica;

import co.edu.uptc.sw2.desingmatch.persistence.EmpresaDao;
import co.edu.uptc.sw2.desingmatch.persistence.entities.Empresa;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class EmpresaLogica {

    @EJB
    private EmpresaDao dao;

    public Empresa saveEmpresa(Empresa empresa) {
        return dao.saveEmpresa(empresa);
    }

    public Empresa loginEmpresa(String email, String password) {
        return dao.loginEmpresa(email, password);
    }
}
