package es.cursojava.hibernate.dao;

import java.util.List;

import es.cursojava.hibernate.dto.CaballoDTO;
import es.cursojava.hibernate.entities.CaballoCarrera;

public class CaballoDAOJDBCImpl implements CaballoDAO{

    @Override
    public void insertar(CaballoCarrera caballo) {
        
    }

    @Override
    public List<CaballoCarrera> obtenerTodos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerTodos'");
    }

    @Override
    public List<CaballoCarrera> obtenerActivos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerActivos'");
    }

    @Override
    public void eliminar(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminar'");
    }

    @Override
    public void actualizar(CaballoCarrera caballo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizar'");
    }

    @Override
    public CaballoCarrera getCaballoPorId(long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCaballoPorId'");
    }

    @Override
    public CaballoDTO obtenerJinete(long caballoId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerJinete'");
    }


}
