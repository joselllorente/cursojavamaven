package es.cursojava.hibernate.dto;

public class CaballoDTO {
    private String nombre;
    private int edad;
    private double velocidadMaxima;
    private int numeroDeTriunfos;
    private double experiencia;
    private boolean activo;
    private double avance;

    public CaballoDTO(String nombre, int edad, double velocidadMaxima, int numeroDeTriunfos, double experiencia) {
        this.nombre = nombre;
        this.edad = edad;
        this.velocidadMaxima = velocidadMaxima;
        this.numeroDeTriunfos = numeroDeTriunfos;
        this.experiencia = experiencia;
        this.activo = true;
    }

    public CaballoDTO(String nombre, int edad, double velocidadMaxima, int numeroDeTriunfos, double experiencia,
            boolean activo) {
        this.nombre = nombre;
        this.edad = edad;
        this.velocidadMaxima = velocidadMaxima;
        this.numeroDeTriunfos = numeroDeTriunfos;
        this.experiencia = experiencia;
        this.activo = activo;
    }



    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public double getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public int getNumeroDeTriunfos() {
        return numeroDeTriunfos;
    }

    public double getExperiencia() {
        return experiencia;
    }

    

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public double getAvance() {
        return avance;
    }
    public void setAvance(double avance) {
        this.avance = avance;
    }

    @Override
    public String toString() {
        return  "|nombre: "+ nombre + " | Edad: " + edad + ", Velocidad: " + velocidadMaxima +
                " km/h, Triunfos: " + numeroDeTriunfos + ", Exp: " + experiencia
                + ", activo: " + activo;
    }
}
