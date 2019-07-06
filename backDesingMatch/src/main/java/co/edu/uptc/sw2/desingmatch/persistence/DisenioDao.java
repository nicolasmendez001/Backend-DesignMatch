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

    public List<Disenio> getDisenios(int project) {
        String query = "SELECT disenios FROM ";
        return null;
    }

    public String addDisenio(Disenio disenio, int project) {
        try {
            Proyecto p = em.find(Proyecto.class, project);
            p.getDisenios().add(disenio);
            em.merge(p);
            return "ok";
        } catch (Exception e) {
            return null;
        }
    }
}
