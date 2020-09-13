/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.prueba.laboratorio.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author galactus
 */
@Entity
public class AsignacionPunto implements Serializable {

    @Id
    @Column(name = "id")
    @Basic(optional = false)
    @GeneratedValue(generator = "asignacionpuntoSec")
    @SequenceGenerator(name = "asignacionpuntoSec",sequenceName = "asignacionpunto_sec",allocationSize = 0)
    private Integer id;
    
    @Column(name = "limite_inferior")
    private Integer limiteInferior;
    
    @Column(name = "limite_superior")
    private Integer limiteSuperior;
    
    @Column(name = "monto_equivalencia")
    private Integer montoEquivalencia;
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLimiteInferior() {
        return limiteInferior;
    }

    public Integer getLimiteSuperior() {
        return limiteSuperior;
    }

    public Integer getMontoEquivalencia() {
        return montoEquivalencia;
    }

    public void setLimiteInferior(Integer limiteInferior) {
        this.limiteInferior = limiteInferior;
    }

    public void setLimiteSuperior(Integer limiteSuperior) {
        this.limiteSuperior = limiteSuperior;
    }

    public void setMontoEquivalencia(Integer montoEquivalencia) {
        this.montoEquivalencia = montoEquivalencia;
    }


    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AsignacionPunto)) {
            return false;
        }
        AsignacionPunto other = (AsignacionPunto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.prueba.laboratorio.modelo.AsignacionPunto[ id=" + id + " ]";
    }
    
}
