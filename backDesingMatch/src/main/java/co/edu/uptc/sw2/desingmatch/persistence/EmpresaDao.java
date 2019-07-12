package co.edu.uptc.sw2.desingmatch.persistence;

import co.edu.uptc.sw2.desingmatch.persistence.entities.Empresa;
import co.edu.uptc.sw2.desingmatch.tools.ManagerContrasenas;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class EmpresaDao {

    @PersistenceContext
    private EntityManager em;

    public Empresa saveEmpresa(Empresa empresa) {
       empresa.setContrasena(ManagerContrasenas.cifrarContrasena(empresa.getContrasena()));
        em.persist(empresa);
        return empresa;
    }

    public Empresa loginEmpresa(String email, String password) {
       String pass = ManagerContrasenas.cifrarContrasena(password);
        String query = "Select e from Empresa e where e.email = '" + email + "'"
                + "and e.contrasena = '" + pass + "'";
        try {
            return (Empresa) em.createQuery(query).getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
