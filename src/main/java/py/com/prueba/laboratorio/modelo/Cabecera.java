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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author galactus
 */
@Entity
public class Cabecera implements Serializable {

    @Id
    @Basic(optional = false)
    @GeneratedValue(generator = "cabeceraSec")
    @SequenceGenerator(name = "cabeceraSec",sequenceName = "cabecera_sec",allocationSize = 0)
    private Integer id;

    @JoinColumn(name = "cliente_id",referencedColumnName = "id")
    @ManyToOne(fetch=FetchType.EAGER)
    private Cliente cliente;

    @Column(name = "puntaje_utilizado")
    @Basic(optional = false)
    private Integer puntajeUtilizado;

    @Column(name = "fecha")
    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;

    @Column(name = "concepto")
    @Basic(optional = false)
    private String concepto;

    public Cabecera() {
        
    }
    
    public Integer getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Integer getPuntajeUtilizado() {
        return puntajeUtilizado;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getConcepto() {
        return concepto;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setPuntajeUtilizado(Integer puntajeUtilizado) {
        this.puntajeUtilizado = puntajeUtilizado;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }


    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cabecera)) {
            return false;
        }
        Cabecera other = (Cabecera) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.prueba.laboratorio.modelo.Cabecera[ id=" + id + " ]";
    }
    
}
