package es.cursojava.excepciones.ejercicio2;

public class Huesped extends Cliente{
    private String dni;

    public Huesped(String nombre, String dni) {
        super(nombre);
        this.dni = dni;
    }

    public String getDni() {
        return dni;
    }

}
