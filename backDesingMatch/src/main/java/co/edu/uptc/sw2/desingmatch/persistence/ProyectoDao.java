package co.edu.uptc.sw2.desingmatch.persistence;

import co.edu.uptc.sw2.desingmatch.persistence.entities.Empresa;
import co.edu.uptc.sw2.desingmatch.persistence.entities.Proyecto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ProyectoDao {

    @PersistenceContext
    private EntityManager em;

    public Proyecto registrarProyecto(Proyecto proyecto, int id) {
        em.persist(proyecto);
        Empresa empresa = em.find(Empresa.class, id);
        empresa.getProyectos().add(proyecto);
        return proyecto;
    }

    public String eliminarProyecto(int idEmpresa, int idProyecto) {
        Empresa empresa = em.find(Empresa.class, idEmpresa);
        Proyecto proyecto = em.find(Proyecto.class, idProyecto);
        empresa.getProyectos().remove(proyecto);
        try {
            em.merge(empresa);
            return "ok";
        } catch (Exception e) {
            return "error";
        }
    }

    public Proyecto editarProyecto(Proyecto proyecto) {
        em.merge(proyecto);
        return proyecto;
    }

    public Proyecto buscarProyecto(int id) {
        Proyecto proyecto = em.find(Proyecto.class, id);
        return proyecto;
    }

    public List<Proyecto> getListaProyectos(String url) {
        String query = "select e from Empresa e where e.url = '" + url + "'";
        Empresa empresa = (Empresa) em.createQuery(query).getSingleResult();
        return empresa.getProyectos();
    }
}
