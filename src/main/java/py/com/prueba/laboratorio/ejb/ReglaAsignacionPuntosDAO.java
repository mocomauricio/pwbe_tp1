/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.prueba.laboratorio.ejb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import py.com.prueba.laboratorio.modelo.ReglaAsignacionPuntos;

@Stateless
public class ReglaAsignacionPuntosDAO {


    @PersistenceContext(unitName = "laboratorioPU")
    private EntityManager em;

    public void agregar(ReglaAsignacionPuntos entity) {
        this.em.persist(entity);
    }

    public List<ReglaAsignacionPuntos> listar() {
        Query q = this.em.createNamedQuery("ReglaAsignacionPuntos.all");
        return (List<ReglaAsignacionPuntos>) q.getResultList();
    }

    public void eliminar(Long regla_asignacion_puntosId) {
        this.em.getTransaction().begin();
        ReglaAsignacionPuntos regla = em.find(ReglaAsignacionPuntos.class, regla_asignacion_puntosId);
        this.em.remove(regla);
        this.em.getTransaction().commit();
    }

    public void actualizar(ReglaAsignacionPuntos regla) {
        this.em.getTransaction().begin();
        this.em.merge(regla);
        this.em.getTransaction().commit();
    }

    public Map getCantidadDePuntos(Double monto) {

        Query q = this.em.createNamedQuery("ReglaAsignacionPuntos.cantidadPuntos");
        q.setParameter("monto", monto.intValue());
        ReglaAsignacionPuntos regla = (ReglaAsignacionPuntos) q.getSingleResult();

        Map m = new HashMap();
        if (regla == null) {
            m.put("estado", -1);
            m.put("mensaje", "No se encontro ninguna regla que este en el rango del monto");
            return m;
        }
        m.put("estado", 0);
        m.put("mensaje", "Exito");

        Double puntos = monto / regla.getMontoEquivalencia().doubleValue();

        m.put("puntos", puntos.intValue());

        return m;
    }
}
