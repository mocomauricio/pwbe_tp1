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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author galactus
 */
@Entity
public class Bolsa implements Serializable {

    @Id
    @Basic(optional = false)
    @GeneratedValue(generator = "bolsaSec")
    @SequenceGenerator(name = "bolsaSec",sequenceName = "bolsa_sec",allocationSize = 0)
    private Integer id;

    @JoinColumn(name = "cliente_id",referencedColumnName = "id")
    @ManyToOne(fetch=FetchType.EAGER)
    private Cliente cliente;
    
    @Column(name = "fecha_asignacion_puntaje")
    private Date fechaAsignacionPuntaje;

    @Column(name = "fecha_caducidad_puntaje")    
    private Date fechaCaducidadPuntaje;
    
    @Column(name = "puntaje_asignacion")
    private Integer puntajeAsignado;

    @Column(name = "puntaje_utilizado")    
    private Integer puntajeUtilizado;
    
    @Column(name = "saldo_puntos")
    private Integer saldoPuntos;
    
    @Column(name = "monto_operacion")
    private Integer montoOperación;

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setFechaAsignacionPuntaje(Date fechaAsignacionPuntaje) {
        this.fechaAsignacionPuntaje = fechaAsignacionPuntaje;
    }

    public void setFechaCaducidadPuntaje(Date fechaCaducidadPuntaje) {
        this.fechaCaducidadPuntaje = fechaCaducidadPuntaje;
    }

    public void setPuntajeAsignado(Integer puntajeAsignado) {
        this.puntajeAsignado = puntajeAsignado;
    }

    public void setPuntajeUtilizado(Integer puntajeUtilizado) {
        this.puntajeUtilizado = puntajeUtilizado;
    }

    public void setSaldoPuntos(Integer saldoPuntos) {
        this.saldoPuntos = saldoPuntos;
    }

    public void setMontoOperación(Integer montoOperación) {
        this.montoOperación = montoOperación;
    }
        
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Date getFechaAsignacionPuntaje() {
        return fechaAsignacionPuntaje;
    }

    public Date getFechaCaducidadPuntaje() {
        return fechaCaducidadPuntaje;
    }

    public Integer getPuntajeAsignado() {
        return puntajeAsignado;
    }

    public Integer getPuntajeUtilizado() {
        return puntajeUtilizado;
    }

    public Integer getSaldoPuntos() {
        return saldoPuntos;
    }

    public Integer getMontoOperación() {
        return montoOperación;
    }

    

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bolsa)) {
            return false;
        }
        Bolsa other = (Bolsa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.prueba.laboratorio.modelo.Bolsa[ id=" + id + " ]";
    }
    
}
