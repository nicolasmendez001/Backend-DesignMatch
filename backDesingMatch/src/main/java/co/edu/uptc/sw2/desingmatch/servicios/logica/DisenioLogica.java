/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.sw2.desingmatch.servicios.logica;

import co.edu.uptc.sw2.desingmatch.persistence.DisenioDao;
import co.edu.uptc.sw2.desingmatch.persistence.entities.Disenio;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class DisenioLogica {

    @EJB
    private DisenioDao dao;

    public Disenio addDisenio(Disenio disenio, int id) {
        return dao.addDisenio(disenio, id);
    }

    public Disenio updateDisenio(Disenio disenio) {
        return dao.updateDisenio(disenio);
    }
}
