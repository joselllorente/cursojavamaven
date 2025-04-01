package es.cursojava.hibernate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_PERSONAS")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // AUTO:	Delega la estrategia al proveedor JPA (Hibernate decide según la BBDD).
    // IDENTITY:	Usa una columna auto-incremental. Funciona bien con MySQL, SQL Server, Oracle 12c+…
    // SEQUENCE:	 Usa una secuencia de base de datos (muy común en Oracle, PostgreSQL, etc.).
    // TABLE: Usa una tabla especial para almacenar y generar identificadores.
    private long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "edad")
    private int edad;

    private String apellidos;

    // Constructores
    public Persona() {}
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }


    @Override
    public String toString() {
        return "Persona{id=" + id + ", nombre='" + nombre + "', edad=" + edad + "}";
    }
}