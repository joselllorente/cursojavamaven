package es.cursojava.enums;

public enum CarreraCaballosEnum {

    CARRERA1 ("Gran Premio 1","Getafe"),
    CARRERA2 ("Gran Premio 2","Alcorcón"),
    CARRERA3 ("Gran Premio 3","Getafe");

    String nombreCarrera;
    String lugarCarrera;

    CarreraCaballosEnum(String nombreCarrera, String lugar){
        this.nombreCarrera = nombreCarrera;
        this.lugarCarrera = lugar;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public String getLugarCarrera() {
        return lugarCarrera;
    }

    public void setLugarCarrera(String lugarCarrera) {
        this.lugarCarrera = lugarCarrera;
    }

    

}

