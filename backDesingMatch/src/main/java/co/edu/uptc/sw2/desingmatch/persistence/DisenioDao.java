/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.sw2.desingmatch.persistence;

import co.edu.uptc.sw2.desingmatch.persistence.entities.Disenio;
import co.edu.uptc.sw2.desingmatch.persistence.entities.Proyecto;
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
        return disenio;

    }

    public Disenio updateDisenio(Disenio disenio) {
        em.merge(disenio);
        return disenio;
    }

    public List<Disenio> geDisenionSinPorcesar() {
        String q = "select d from Disenio d where d.estado = 'EN_PROCESO'";
        return em.createQuery(q).getResultList();
    }
}
