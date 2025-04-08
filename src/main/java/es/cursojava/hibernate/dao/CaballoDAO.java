package es.cursojava.hibernate.dao;

import java.util.List;

import es.cursojava.hibernate.entities.CaballoCarrera;

public interface CaballoDAO {
    void insertar(CaballoCarrera caballo);
    List<CaballoCarrera> obtenerTodos();
    List<CaballoCarrera> obtenerActivos();
    void eliminar(Long id);
    void actualizar(CaballoCarrera caballo);
}