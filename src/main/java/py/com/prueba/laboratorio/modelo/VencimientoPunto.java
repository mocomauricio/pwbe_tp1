/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.prueba.laboratorio.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author galactus
 */
@Entity
public class VencimientoPunto implements Serializable {

    @Id
    @Basic(optional = false)
    @GeneratedValue(generator = "vencimientopuntoSec")
    @SequenceGenerator(name = "vencimientopuntoSec",sequenceName = "vencimientopunto_sec",allocationSize = 0)
    private Integer id;
    
    @Column(name = "fecha_inicio_validez")
    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    private Date fechaInicioValidez;

    @Column(name = "fecha_fin_validez")
    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    private Date fechaFinValidez;
    
    @Column(name = "dias_duracion")
    @Basic(optional = false)
    private Integer diasDuracion;

    public VencimientoPunto() {
        
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaInicioValidez() {
        return fechaInicioValidez;
    }

    public Date getFechaFinValidez() {
        return fechaFinValidez;
    }

    public Integer getDiasDuracion() {
        return diasDuracion;
    }

    public void setFechaInicioValidez(Date fechaInicioValidez) {
        this.fechaInicioValidez = fechaInicioValidez;
    }

    public void setFechaFinValidez(Date fechaFinValidez) {
        this.fechaFinValidez = fechaFinValidez;
    }

    public void setDiasDuracion(Integer diasDuracion) {
        this.diasDuracion = diasDuracion;
    }


    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VencimientoPunto)) {
            return false;
        }
        VencimientoPunto other = (VencimientoPunto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.prueba.laboratorio.modelo.VencimientoPunto[ id=" + id + " ]";
    }
    
}
