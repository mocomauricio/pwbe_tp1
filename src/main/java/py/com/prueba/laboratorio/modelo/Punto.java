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
public class Punto implements Serializable {

    @Id
    @Column(name = "id")
    @Basic(optional = false)
    @GeneratedValue(generator = "puntoSec")
    @SequenceGenerator(name = "puntoSec",sequenceName = "punto_sec",allocationSize = 0)
    private Integer id;

    @Column(name = "descripcion",length = 512)
    private String descripcion;
    
    @Column(name = "puntos_requeridos")
    private Integer puntosRequeridos;

    public void setIdPunto(Integer id) {
        this.id = id;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPuntosRequeridos(Integer puntosRequeridos) {
        this.puntosRequeridos = puntosRequeridos;
    }

    public Integer getIdPunto() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Integer getPuntosRequeridos() {
        return puntosRequeridos;
    }
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Punto)) {
            return false;
        }
        Punto other = (Punto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.prueba.laboratorio.modelo.Punto[ id=" + id + " ]";
    }
    
}
