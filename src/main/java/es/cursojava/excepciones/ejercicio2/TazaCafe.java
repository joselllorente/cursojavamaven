package es.cursojava.excepciones.ejercicio2;

public class TazaCafe {
    private String tipoCafe;
    private double temperatura;
    
    public TazaCafe(String tipoCafe, double temperatura) {
        this.tipoCafe = tipoCafe;
        this.temperatura = temperatura;
    }

    public TazaCafe(String tipoCafe) {
        this.tipoCafe = tipoCafe;
        this.temperatura = Math.random()*100;
    }
    
    public String getTipoCafe() {
        return tipoCafe;
    }

    public double getTemperatura() {
        return temperatura;
    }


}
