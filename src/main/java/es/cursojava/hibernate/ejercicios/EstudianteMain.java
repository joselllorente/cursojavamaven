package es.cursojava.hibernate.ejercicios;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import es.cursojava.hibernate.HibernateUtil;
import es.cursojava.hibernate.dto.EstudianteDTO;
import es.cursojava.hibernate.entities.CarnetBiblioteca;
import es.cursojava.hibernate.entities.Estudiante;
import es.cursojava.hibernate.exceptions.EstudianteException;
import es.cursojava.hibernate.services.EstudianteService;
import es.cursojava.inicio.funciones.Utilidades;

public class EstudianteMain {

    public static void main(String[] args) {
        EstudianteMain em = new EstudianteMain();
        em.consultarEstudiantes();
       
    }

    private void insertarEstudianteFront(){
        //Presentacion
        String nombre = Utilidades.pideDatoCadena("Nombre del estudiante: ");
        String email = Utilidades.pideDatoCadena("Email del estudiante: ");
        int edad = Utilidades.pideDatoNumerico("Edad del estudiante: ");
        Date fechaDeEmision = Utilidades.pideDatoDate("Fecha de emisión del carnet: ");
        Date fechaDeExpiracion = Utilidades.pideDatoDate("Fecha de expiración del carnet: ");

        EstudianteDTO estudianteDTO = new EstudianteDTO(nombre, edad, email, fechaDeEmision, fechaDeExpiracion);
        EstudianteService servicio = new EstudianteService();
        try {
            servicio.insertarEstudiante(estudianteDTO);
        } catch (EstudianteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
   
    private static void consultarEstudiantes() {
        EstudianteService servicio = new EstudianteService();
        List<Estudiante> estudiantes = servicio.getEstudiantes();
        for (Estudiante estudiante : estudiantes) {
            System.out.println(estudiante);
        }
    }
}