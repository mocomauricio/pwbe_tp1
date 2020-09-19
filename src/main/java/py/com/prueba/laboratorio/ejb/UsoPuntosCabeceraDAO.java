/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.prueba.laboratorio.ejb;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import py.com.prueba.laboratorio.modelo.Cliente;
import py.com.prueba.laboratorio.modelo.ConceptoPuntos;
import py.com.prueba.laboratorio.modelo.UsoPuntosCabecera;

@Stateless
public class UsoPuntosCabeceraDAO {

    @Inject
    ConceptoPuntosDAO conceptoDAO;
    
    @Inject
    UsoPuntosDetallesDAO usoDetalleDAO;
    
    @PersistenceContext(unitName = "laboratorioPU")
    private EntityManager em;

    public void agregar(UsoPuntosCabecera entity) {
        this.em.persist(entity);
    }

    public List<UsoPuntosCabecera> listar() {
        Query q = this.em.createNamedQuery("UsoPuntosCabecera.all");
        return (List<UsoPuntosCabecera>) q.getResultList();
    }

    public void eliminar(Long uso_puntos_cabeceraId) {
        this.em.getTransaction().begin();
        UsoPuntosCabecera uso = em.find(UsoPuntosCabecera.class, uso_puntos_cabeceraId);
        this.em.remove(uso);
        this.em.getTransaction().commit();
    }

    public void actualizar(UsoPuntosCabecera uso) {
        this.em.getTransaction().begin();
        this.em.merge(uso);
        this.em.getTransaction().commit();
    }
    
    public List<UsoPuntosCabecera> listarByConcepto(Integer idConcepto){
        Query q = this.em.createNamedQuery("UsoPuntosCabecera.byConcepto");
        return (List<UsoPuntosCabecera>) q.setParameter("idConcepto", idConcepto).getResultList();
    }

    public Object listarByFecha(String fechaInicio, String fechaFin) throws ParseException {
        Query q = this.em.createNamedQuery("UsoPuntosCabecera.byFecha");
        Date fechaInicioDate = new SimpleDateFormat("dd/MM/yyy").parse(fechaInicio);
        Date fechaFinDate = new SimpleDateFormat("dd/MM/yyy").parse(fechaFin);
        
        return (List<UsoPuntosCabecera>) 
                q.setParameter("fechaInicio", fechaInicioDate)
                .setParameter("fechaFin", fechaFinDate)
                .getResultList();
    }
    
    public List<UsoPuntosCabecera> listarByCliente(Integer idCliente){
        Query q = this.em.createNamedQuery("UsoPuntosCabecera.byCliente");
        Cliente cliente = new Cliente();
        cliente.setId(idCliente);
        return (List<UsoPuntosCabecera>) q.setParameter("idCliente", cliente).getResultList();
    }

    public void utilizarPuntos(Integer idCliente, Integer idConcepto) {
        Cliente cliente = new Cliente();
        cliente.setId(idCliente);
        
        ConceptoPuntos concepto = conceptoDAO.getById(idConcepto);
        
        // Se crea el Uso Puntos cabecera
        UsoPuntosCabecera cabecera =  new UsoPuntosCabecera();
        cabecera.setConcepto(idConcepto);
        cabecera.setCliente(cliente);
        cabecera.setPuntosUtilizados(concepto.getPuntosRequeridos());
        this.em.persist(cabecera);
        
        // Se crean los Uso Puntos Detalle
        usoDetalleDAO.agregarDetallesDeCabecera(cabecera);
        
    }
}
