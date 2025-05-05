package es.cursojava.hibernate.dto;

public class CarreraDTO {
    private String nombreCarrera;
    private String nombreCaballo;
    private String nombreJinete;

    public CarreraDTO(String nombreCarrera, String nombreCaballo, String nombreJinete) {
        this.nombreCarrera = nombreCarrera;
        this.nombreCaballo = nombreCaballo;
        this.nombreJinete = nombreJinete;
    }
    
    public String getNombreCarrera() {
        return nombreCarrera;
    }
    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }
    public String getNombreCaballo() {
        return nombreCaballo;
    }
    public void setNombreCaballo(String nombreCaballo) {
        this.nombreCaballo = nombreCaballo;
    }
    public String getNombreJinete() {
        return nombreJinete;
    }
    public void setNombreJinete(String nombreJinete) {
        this.nombreJinete = nombreJinete;
    }

    

}
