package py.com.prueba.laboratorio.ejb;

import py.com.prueba.laboratorio.modelo.Bolsa;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class BolsaDAO {
    @PersistenceContext(unitName = "laboratorioPU")
    EntityManager em;

    public void agregar(Bolsa entidad) {
        this.em.persist(entidad);
    }

    public void modificar(Bolsa entidad) {
        this.em.merge(entidad);
    }

    public void eliminar(Integer id) {
        this.em.remove(this.em.find(Bolsa.class,id));
    }

    @SuppressWarnings("unchecked")
    public List<Bolsa> lista() {
        Query q = em.createQuery("SELECT p FROM Bolsa p");
        return (List<Bolsa>)q.getResultList();
    }
}
