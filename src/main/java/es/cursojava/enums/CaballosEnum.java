package es.cursojava.enums;

public enum CaballosEnum {

    CABALLO1("Nombre Caballo1", 5, 10),
    CABALLO2("Nombre Caballo2", 6, 8),
    CABALLO3("Nombre Caballo3", 7, 11);
    
    String nombre;
    int edad;
    int experiencia;

    CaballosEnum(String nombre,int edad, int experiencia){
        this.nombre = nombre;
        this.edad = edad;
        this.experiencia = experiencia;
    }

    CaballosEnum(String nombre,int edad, int experiencia, 
        String nombreJinete, String nacionalidadJinete){
        this.nombre = nombre;
        this.edad = edad;
        this.experiencia = experiencia;
        
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

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    

}
