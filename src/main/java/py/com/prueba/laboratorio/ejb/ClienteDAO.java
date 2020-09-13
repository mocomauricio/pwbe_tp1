package py.com.prueba.laboratorio.ejb;

import py.com.prueba.laboratorio.modelo.Cliente;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class ClienteDAO {
    @PersistenceContext(unitName = "laboratorioPU")
    EntityManager em;

    public void agregar(Cliente entidad) {
        this.em.persist(entidad);
    }

    public void modificar(Cliente entidad) {
        this.em.merge(entidad);
    }

    public void eliminar(Integer id) {
        this.em.remove(this.em.find(Cliente.class,id));
    }

    @SuppressWarnings("unchecked")
    public List<Cliente> lista() {
        Query q = em.createQuery("SELECT p FROM Cliente p");
        return (List<Cliente>)q.getResultList();
    }
}
