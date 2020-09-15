package py.com.prueba.laboratorio.ejb;

import py.com.prueba.laboratorio.modelo.VencimientoPunto;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class VencimientoPuntoDAO {
    @PersistenceContext(unitName = "laboratorioPU")
    EntityManager em;

    public VencimientoPunto get(Integer id) {
        return em.find(VencimientoPunto.class, id);
    }

    public void persist(VencimientoPunto entidad) {
        this.em.persist(entidad);
    }

    public void merge(VencimientoPunto entidad) {
        this.em.merge(entidad);
    }

    public void delete(Integer id) {
        this.em.remove(this.em.find(VencimientoPunto.class,id));
    }
    

    @SuppressWarnings("unchecked")
    public List<VencimientoPunto> lista() {
        Query q = em.createQuery("SELECT p FROM VencimientoPunto p");
        return (List<VencimientoPunto>)q.getResultList();
    }
}
