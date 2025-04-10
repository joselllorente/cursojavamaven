package es.cursojava.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import es.cursojava.hibernate.HibernateUtil;
import es.cursojava.hibernate.entities.Estudiante;

public class EstaudianteDAOImpl implements EstudianteDAO{

    @Override
    public void insertarEstudiante(Estudiante estudiante) {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        session.persist(estudiante);
        tx.commit();
        System.out.println("Estudiante insertado exitosamente.");
        
        session.close();
    }

    @Override
    public List<Estudiante> getEstudiantes() {
        Session session = HibernateUtil.getSession();
        
        return session.createQuery("from Estudiante", Estudiante.class).list();
        
        
    }

    @Override
    public Estudiante getEstudiante(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEstudiante'");
    }

    @Override
    public void eliminarEstudiante(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarEstudiante'");
    }

    @Override
    public void eliminarEstudiante(Estudiante estudiante) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarEstudiante'");
    }

    @Override
    public void actualizarEstudiante(Estudiante estudiante) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizarEstudiante'");
    }

}
