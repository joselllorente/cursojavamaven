package es.cursojava.hibernate.front;

import java.util.List;

import es.cursojava.hibernate.dto.CaballoDTO;
import es.cursojava.hibernate.services.CarreraService;
import es.cursojava.inicio.funciones.Utilidades;

public class CarreraCaballosFront {
    private CarreraService servicio;
    private String nombreCarrera;

    public CarreraCaballosFront (String nombreCarrera){
        this.servicio = new CarreraService();
        this.nombreCarrera = nombreCarrera;
    }

    public void iniciaMenuCarrera() {
        System.out.println("Bienvenido a la carrera "+ this.nombreCarrera);
        int opcion;
        do {
            Utilidades.pintaMenu(new String[]{"1. Insertar nuevo caballo ",
                "2. Mostrar Caballos","3. Iniciar carrera","4. Borrar Caballo","5. Salir"} , "");
            opcion = Utilidades.pideDatoNumerico("Elige una opción: ");
            
            switch (opcion) {
                case 1:
                    creaCaballo();
                    break;
                case 2:
                    mostrarCaballos();
                    break;
                case 3:
                    iniciarCarrera();
                    break;
                case 4:
                    eliminarCaballo();
                    break;
                case 5:
                    System.out.println("Aaaadios!");;
                    break;
                default:
                    System.out.println("Opción incorrecta");
            }
        } while (opcion != 5);

    }

    private CaballoDTO creaCaballo () {
       
        String nombre = Utilidades.pideDatoCadena("Nombre: ");
        int edad = Utilidades.pideDatoNumerico("edad: ");
        double velocidad = Utilidades.pideDatoDecimal("Velocidad máxima (km/h): ");
        int triunfos = Utilidades.pideDatoNumerico("Número de triunfos: : ");
        double experiencia = Utilidades.pideDatoDecimal("Experiencia (0.0 a 10.0): ");
        String activo = Utilidades.pideDatoCadena("¿Está activo? ");

        CaballoDTO caballoDto = new CaballoDTO(nombre, edad, velocidad, triunfos, experiencia, 
                activo.equalsIgnoreCase("si"));
        servicio.insertarCaballo(caballoDto);
        return caballoDto;
    }

    private void mostrarCaballos (){
        List<CaballoDTO> caballos = servicio.obtenerCaballos(false);
        caballos.forEach(System.out::println);
    }

    private  void iniciarCarrera (){
        servicio.simularCarrera(servicio.obtenerCaballos(true));
    }

    private void eliminarCaballo (){
        //mostrarCaballos();
        int id = Utilidades.pideDatoNumerico("Introduce el id del caballo a eliminar");
        servicio.eliminarCaballo(id);
        System.out.println("Caballo con id "+id + " borrado");
    }
}
