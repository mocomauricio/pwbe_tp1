package py.com.prueba.laboratorio.ejb;

import py.com.prueba.laboratorio.modelo.Punto;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class PuntoDAO {
    @PersistenceContext(unitName = "laboratorioPU")
    EntityManager em;

    public Punto get(Integer id) {
        return em.find(Punto.class, id);
    }

    public void persist(Punto entidad) {
        this.em.persist(entidad);
    }

    public void merge(Punto entidad) {
        this.em.merge(entidad);
    }

    public void delete(Integer id) {
        this.em.remove(this.em.find(Punto.class,id));
    }
    

    @SuppressWarnings("unchecked")
    public List<Punto> lista() {
        Query q = em.createQuery("SELECT p FROM Punto p");
        return (List<Punto>)q.getResultList();
    }
}
