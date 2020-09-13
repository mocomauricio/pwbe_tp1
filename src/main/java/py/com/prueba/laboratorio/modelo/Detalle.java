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
public class Detalle implements Serializable {

    @Id
    @Basic(optional = false)
    @GeneratedValue(generator = "detalleSec")
    @SequenceGenerator(name = "detalleSec",sequenceName = "detalle_sec",allocationSize = 0)
    private Integer id;

    @JoinColumn(name = "cabecera_id",referencedColumnName = "id")
    @ManyToOne(fetch=FetchType.EAGER)
    private Cabecera cabecera;
    
    
    @Column(name = "puntaje_utilizado")
    private Integer puntajeUtilizado;
    
    @JoinColumn(name = "bolsa_id",referencedColumnName = "id")
    @ManyToOne(fetch=FetchType.EAGER)
    private Bolsa bolsa;
    
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cabecera getCabecera() {
        return cabecera;
    }

    public Integer getPuntajeUtilizado() {
        return puntajeUtilizado;
    }

    public Bolsa getBolsa() {
        return bolsa;
    }

    public void setCabecera(Cabecera cabecera) {
        this.cabecera = cabecera;
    }

    public void setPuntajeUtilizado(Integer puntajeUtilizado) {
        this.puntajeUtilizado = puntajeUtilizado;
    }

    public void setBolsa(Bolsa bolsa) {
        this.bolsa = bolsa;
    }


    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detalle)) {
            return false;
        }
        Detalle other = (Detalle) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.prueba.laboratorio.modelo.Detalle[ id=" + id + " ]";
    }
    
}
