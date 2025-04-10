package es.cursojava.hibernate.dao;

import java.util.List;

import es.cursojava.hibernate.entities.Estudiante;

public interface EstudianteDAO {
    void insertarEstudiante (Estudiante estudiante);

    List<Estudiante> getEstudiantes ();

    Estudiante getEstudiante (Long id);
    
    void eliminarEstudiante (Long id);

    void eliminarEstudiante (Estudiante estudiante);

    void actualizarEstudiante (Estudiante estudiante);
}
