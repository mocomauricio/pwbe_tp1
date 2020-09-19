/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.prueba.laboratorio.ejb;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import py.com.prueba.laboratorio.modelo.BolsaPuntos;

@Startup
@Singleton
public class TheSingleton {

    @Inject
    BolsaPuntosDAO bolsaDAO;


    @PostConstruct
    public void init() {
    }

    @Schedule(hour = "*", minute = "0", second = "*/1", persistent = false)
    public void actualizarBolsasPuntos() {
        try {
            List<BolsaPuntos> bolsasVencidas = bolsaDAO.listarBolsasVencidas();
            for (BolsaPuntos bolsaVencida : bolsasVencidas) {
                bolsaVencida.setEstado("VENCIDO");
                bolsaDAO.actualizar(bolsaVencida);
            }
        } catch (Exception e) {
            
        }
    }

}
