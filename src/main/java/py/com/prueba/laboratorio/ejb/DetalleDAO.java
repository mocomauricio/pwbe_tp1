package py.com.prueba.laboratorio.ejb;

import py.com.prueba.laboratorio.modelo.Detalle;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class DetalleDAO {
    @PersistenceContext(unitName = "laboratorioPU")
    EntityManager em;

    public Detalle get(Integer id) {
        return em.find(Detalle.class, id);
    }

    public void persist(Detalle entidad) {
        this.em.persist(entidad);
    }

    public void merge(Detalle entidad) {
        this.em.merge(entidad);
    }

    public void delete(Integer id) {
        this.em.remove(this.em.find(Detalle.class,id));
    }
    

    @SuppressWarnings("unchecked")
    public List<Detalle> lista() {
        Query q = em.createQuery("SELECT p FROM Detalle p");
        return (List<Detalle>)q.getResultList();
    }
}
