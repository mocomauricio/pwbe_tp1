package py.com.prueba.laboratorio.modelo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable{
    @Id
    @Column(name = "id")
    @Basic(optional = false)
    @GeneratedValue(generator = "clienteSec")
    @SequenceGenerator(name = "clienteSec",sequenceName = "cliente_sec",allocationSize = 0)
    private Integer id;
        
    @Column(name = "nombre",length = 50)
    @Basic(optional = false)
    private String nombre;
    
    @Column(name = "apellido",length = 50)
    @Basic(optional = false)
    private String apellido;
    
    @Column(name = "numero_documento",length = 50)
    @Basic(optional = false)
    private String numeroDocumento;
    
    @Column(name = "tipo_documento",length = 50)
    @Basic(optional = false)
    private String tipoDocumento;
    
    @Column(name = "nacionalidad",length = 50)
    @Basic(optional = false)
    private String nacionalidad;
    
    @Column(name = "email",length = 50)
    @Basic(optional = false)
    private String email;
    
    @Column(name = "telefono",length = 50)
    @Basic(optional = false)
    private String telefono;

    @Column(name = "fecha_nacimiento")
    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    
    public Cliente() {

    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return nombre+ " "+apellido;
    }
}
