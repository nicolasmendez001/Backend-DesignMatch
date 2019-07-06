package co.edu.uptc.sw2.desingmatch.servicios.logica;
import co.edu.uptc.sw2.desingmatch.persistence.ProyectoDao;
import co.edu.uptc.sw2.desingmatch.persistence.entities.Proyecto;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author lives
 */
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

    public Proyecto editarProyecto(Proyecto proyecto) {
        return proyectoDao.editarProyecto(proyecto);
    }

    public Proyecto buscarProyecto(int id) {
        return proyectoDao.buscarProyecto(id);
    }

    public List<Proyecto> getListaProyectos(String url) {
        return proyectoDao.getListaProyectos(url);
    }
}
