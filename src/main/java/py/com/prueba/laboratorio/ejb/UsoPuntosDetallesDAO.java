/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.prueba.laboratorio.ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import py.com.prueba.laboratorio.modelo.BolsaPuntos;
import py.com.prueba.laboratorio.modelo.UsoPuntosCabecera;
import py.com.prueba.laboratorio.modelo.UsoPuntosDetalle;

@Stateless
public class UsoPuntosDetallesDAO {

    @Inject
    BolsaPuntosDAO bolsaDAO;
    
    @PersistenceContext(unitName = "laboratorioPU")
    private EntityManager em;

    public void agregar(UsoPuntosDetalle entity) {
        this.em.persist(entity);
    }

    public List<UsoPuntosDetalle> listar() {
        Query q = this.em.createNativeQuery("UsoPuntosDetalle.all");
        return (List<UsoPuntosDetalle>) q.getResultList();
    }

    public void eliminar(Long uso_puntos_detalleId) {
        this.em.getTransaction().begin();
        UsoPuntosDetalle uso = em.find(UsoPuntosDetalle.class, uso_puntos_detalleId);
        this.em.remove(uso);
        this.em.getTransaction().commit();
    }

    public void actualizar(UsoPuntosDetalle uso) {
        this.em.getTransaction().begin();
        this.em.merge(uso);
        this.em.getTransaction().commit();
    }

    void agregarDetallesDeCabecera(UsoPuntosCabecera cabecera) {
        int montoTotal = cabecera.getPuntosUtilizados();
        
        List<BolsaPuntos> bolsas = bolsaDAO.listarByClienteEnOrden(cabecera.getCliente().getId());
        int i = 0, montoBolsa;
        BolsaPuntos bolsaActual;
        
        while (montoTotal>0){
            UsoPuntosDetalle usoDetalle = new UsoPuntosDetalle();
            usoDetalle.setCabecera(cabecera);
            bolsaActual = bolsas.get(i++);
            montoBolsa = bolsaActual.getPuntosSaldo();
            
            if (montoBolsa >= montoTotal){
                usoDetalle.setPuntosUtilizados(montoTotal);
                bolsaActual.setPuntosUtilizados(bolsaActual.getPuntosUtilizados() + montoTotal);
                bolsaActual.setPuntosSaldo(bolsaActual.getPuntosSaldo() - montoTotal);
                bolsaDAO.actualizar(bolsaActual);
                montoTotal = 0;
            }else {
                usoDetalle.setPuntosUtilizados(montoBolsa);
                bolsaActual.setPuntosUtilizados(bolsaActual.getPuntosAsignados());
                bolsaActual.setPuntosSaldo(0);
                bolsaDAO.actualizar(bolsaActual);
                montoTotal = montoTotal - montoBolsa;
            }
            this.agregar(usoDetalle);
        }
    }

}
