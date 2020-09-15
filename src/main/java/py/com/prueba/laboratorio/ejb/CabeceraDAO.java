package py.com.prueba.laboratorio.ejb;

import py.com.prueba.laboratorio.modelo.Cabecera;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class CabeceraDAO {
    @PersistenceContext(unitName = "laboratorioPU")
    EntityManager em;

    public Cabecera get(Integer id) {
        return em.find(Cabecera.class, id);
    }

    public void persist(Cabecera entidad) {
        this.em.persist(entidad);
    }

    public void merge(Cabecera entidad) {
        this.em.merge(entidad);
    }

    public void delete(Integer id) {
        this.em.remove(this.em.find(Cabecera.class,id));
    }
    

    @SuppressWarnings("unchecked")
    public List<Cabecera> lista() {
        Query q = em.createQuery("SELECT p FROM Cabecera p");
        return (List<Cabecera>)q.getResultList();
    }
}
