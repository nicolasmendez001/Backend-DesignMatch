package co.edu.uptc.sw2.desingmatch.persistence;

import co.edu.uptc.sw2.desingmatch.persistence.entities.Empresa;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class EmpresaDao {

    @PersistenceContext
    private EntityManager em;

    public Empresa saveEmpresa(Empresa empresa) {
        em.persist(empresa);
        return empresa;
    }

    public Empresa loginEmpresa(String email, String password) {
        String query = "Select e from Empresa e where e.email = '" + email + "'"
                + "and e.contrasena = '" + password + "'";
        try {
            return (Empresa) em.createQuery(query).getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
