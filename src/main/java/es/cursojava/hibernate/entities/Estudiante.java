package es.cursojava.hibernate.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "TB_ESTUDIANTE")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Nombre", nullable = false, unique = true, length = 50)
    @NotNull(message = "El nombre es obligatorio")
    @Size(max = 50, message = "El nombre no puede tener más de 50 caracteres")
    private String nombre;

    @Column(name = "Email", nullable = true, unique = true, length = 100)
    private String email;

    @Column(name = "Edad", nullable = false)
    @Min(18)
    @Max(90)
    private int edad;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    // @OneToOne
    @JoinColumn(name = "FK_Carnet") // crea la foreign key en la tabla Usuario
    private CarnetBiblioteca carnetBiblioteca;

    public Estudiante() {

    }

    public Estudiante(
            @NotNull(message = "El nombre es obligatorio") @Size(max = 50, message = "El nombre no puede tener más de 50 caracteres") String nombre,
            @Min(2) @Max(30) int edad,
            String email,
            CarnetBiblioteca carnetBiblioteca) {
        this.nombre = nombre;
        this.edad = edad;
        this.email = email;
        this.carnetBiblioteca = carnetBiblioteca;
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

    public CarnetBiblioteca getCarnetBiblioteca() {
        return carnetBiblioteca;
    }

    public void setcarnetBiblioteca(CarnetBiblioteca carnetBiblioteca) {
        this.carnetBiblioteca = carnetBiblioteca;
    }

    @Override
    public String toString() {
        return "Estudiante [id=" + id + ", nombre=" + nombre + ", email=" + email + ", edad=" + edad
                + ", carnetBiblioteca=" + carnetBiblioteca + "]";
    }

    

}
