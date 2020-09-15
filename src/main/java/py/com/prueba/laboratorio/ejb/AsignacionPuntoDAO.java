package py.com.prueba.laboratorio.ejb;

import py.com.prueba.laboratorio.modelo.AsignacionPunto;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class AsignacionPuntoDAO {
    @PersistenceContext(unitName = "laboratorioPU")
    EntityManager em;

    public AsignacionPunto get(Integer id) {
        return em.find(AsignacionPunto.class, id);
    }

    public void persist(AsignacionPunto entidad) {
        this.em.persist(entidad);
    }

    public void merge(AsignacionPunto entidad) {
        this.em.merge(entidad);
    }

    public void delete(Integer id) {
        this.em.remove(this.em.find(AsignacionPunto.class,id));
    }
    

    @SuppressWarnings("unchecked")
    public List<AsignacionPunto> lista() {
        Query q = em.createQuery("SELECT p FROM AsignacionPunto p");
        return (List<AsignacionPunto>)q.getResultList();
    }
}
