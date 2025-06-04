package es.cursojava.hibernate.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_CarnetBiblioteca")
public class CarnetBiblioteca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date fechaDeEmision;
    private Date fechaDeExpiracion;

    public CarnetBiblioteca() {
    }

    public CarnetBiblioteca(Date fechaDeEmision, Date fechaDeExpiracion) {
        this.fechaDeEmision = fechaDeEmision;
        this.fechaDeExpiracion = fechaDeExpiracion;
    }

    public Date getFechaDeEmision() {
        return fechaDeEmision;
    }

    public void setFechaDeEmision(Date fechaDeEmision) {
        this.fechaDeEmision = fechaDeEmision;
    }

    public Date getFechaDeExpiracion() {
        return fechaDeExpiracion;
    }

    public void setFechaDeExpiracion(Date fechaDeExpiracion) {
        this.fechaDeExpiracion = fechaDeExpiracion;
    }

    @Override
    public String toString() {
        return "CarnetBiblioteca [id=" + id + ", fechaDeEmision=" + fechaDeEmision + ", fechaDeExpiracion="
                + fechaDeExpiracion + "]";
    }

    
}
