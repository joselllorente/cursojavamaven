package es.cursojava.hibernate.dto;

import java.util.Date;

public class EstudianteDTO {
    private String nombre;
    private int edad;
    private String email;
    private Date fechaDeEmision;
    private Date fechaDeExpiracion;

    public EstudianteDTO() {
    }

    public EstudianteDTO(String nombre, int edad, String email, Date fechaDeEmision, Date fechaDeExpiracion) {
        this.nombre = nombre;
        this.edad = edad;
        this.email = email;
        this.fechaDeEmision = fechaDeEmision;
        this.fechaDeExpiracion = fechaDeExpiracion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    
    
}

