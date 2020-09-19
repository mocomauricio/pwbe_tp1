package py.com.prueba.laboratorio.ejb;

import py.com.prueba.laboratorio.modelo.Cliente;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
public class ClienteDAO {

    @PersistenceContext(unitName = "laboratorioPU")
    private EntityManager em;

    public void agregar(Cliente entity) {
        this.em.persist(entity);
    }

    public List<Cliente> listar() {
        Query q = this.em.createNamedQuery("Cliente.all");
        return (List<Cliente>) q.getResultList();
    }

    public void eliminar(Long clienteId) {
        this.em.getTransaction().begin();
        Cliente c = em.find(Cliente.class, clienteId);
        this.em.remove(c);
        this.em.getTransaction().commit();
    }

    public void actualizar(Cliente cliente) {
        this.em.getTransaction().begin();
        this.em.merge(cliente);
        this.em.getTransaction().commit();
    }
    
    public List<Cliente> listarByNombre(String nombreCliente) {
        Query q = this.em.createNamedQuery("Cliente.byNombre");
        return (List<Cliente>) q
                .setParameter("nombreCliente", '%' + nombreCliente + '%')
                .getResultList();
    }
    
    public List<Cliente> listarByApellido(String nombreApellido) {
        Query q = this.em.createNamedQuery("Cliente.byApellido");
        return (List<Cliente>) q
                .setParameter("nombreApellido", '%' + nombreApellido + '%')
                .getResultList();
    }
    
    public List<Cliente> listarByCumple(String cumple) throws ParseException {
        Date fechaCumple = new SimpleDateFormat("dd/MM/yyyy").parse(cumple);
        Query q = this.em.createNamedQuery("Cliente.byCumple");
        
        
        List<Cliente> todos = (List<Cliente>) q.getResultList();
        List<Cliente> listaCumple = new LinkedList<Cliente>();
        Date fechaNacimiento;
        
        for (Cliente cliente : todos) {
            fechaNacimiento = cliente.getFechaNacimiento();
             
            String fechaNacimientoString = new SimpleDateFormat("dd/MM").format(fechaNacimiento);
            String fechaCumpleString = new SimpleDateFormat("dd/MM").format(fechaCumple);
            if (fechaNacimiento != null && fechaCumple != null && fechaNacimientoString.equals(fechaCumpleString)){
                listaCumple.add(cliente);
            }
        }
        
        return listaCumple;
    }
}
