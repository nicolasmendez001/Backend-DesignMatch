/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.sw2.desingmatch.persistence;

import co.edu.uptc.sw2.desingmatch.persistence.entities.Disenio;
import co.edu.uptc.sw2.desingmatch.persistence.entities.Proyecto;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class DisenioDao {

    @PersistenceContext
    private EntityManager em;

    public Disenio addDisenio(Disenio disenio, int id) {
        Proyecto proyecto = em.find(Proyecto.class, id);
        proyecto.getDisenios().add(disenio);
        return proyecto.getDisenios().get(proyecto.getDisenios().indexOf(disenio));

    }

    public Disenio updateDisenio(Disenio disenio) {
        em.merge(disenio);
        return disenio;
    }

    public List<Disenio> geDisenionSinPorcesar() {
        String q = "select d from Disenio d where d.estado = 'EN_PROCESO'";
        return em.createQuery(q).getResultList();
    }

    public List<Disenio> loadDisenios(int idProyecto) {
        System.out.println("Id ->> " + idProyecto);
        Proyecto proyecto = em.find(Proyecto.class, idProyecto);
        return proyecto.getDisenios();
    }

    public List<String> getPath(int id) {
        
        //String q = "select d.originalPath from (elect p.disenios from Proyecto p where p.id = '" + id +"')";
        String q = "select p.disenios from Proyecto p where p.id = '" + id + "'";
        List<Disenio> list = em.createQuery(q).getResultList();
        List<String> l = new ArrayList<>();
        for (Disenio d : list) {
            l.add(d.getOriginalPath());
        }
        return l;
    }
}
