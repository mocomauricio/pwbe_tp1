/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.prueba.laboratorio.ejb;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import py.com.prueba.laboratorio.modelo.VencimientoPuntos;

@Stateless
public class VencimientoPuntosDAO {

    @PersistenceContext(unitName = "laboratorioPU")
    private EntityManager em;

    public void agregar(VencimientoPuntos entity) {
        this.em.persist(entity);
    }

    public List<VencimientoPuntos> listar() {
        Query q = this.em.createNamedQuery("VencimientoPuntos.all");
        return (List<VencimientoPuntos>) q.getResultList();
    }

    public void eliminar(Long vencimiento_puntosId) {
        this.em.getTransaction().begin();
        VencimientoPuntos venc = em.find(VencimientoPuntos.class, vencimiento_puntosId);
        this.em.remove(venc);
        this.em.getTransaction().commit();
    }

    public void actualizar(VencimientoPuntos venc) {
        this.em.getTransaction().begin();
        this.em.merge(venc);
        this.em.getTransaction().commit();
    }
    
    public Integer getDiasCaducidad() {
        Query q = this.em.createNamedQuery("VencimientoPuntos.duracionByRango");
        Date actual = new Date();
        return (Integer) q.setParameter("fechaAsignacion", actual).getSingleResult();
    }
}
