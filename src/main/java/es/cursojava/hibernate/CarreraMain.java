package es.cursojava.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import es.cursojava.enums.CarreraCaballosEnum;
import es.cursojava.hibernate.dto.CarreraDTO;
import es.cursojava.hibernate.entities.CaballoCarrera;
import es.cursojava.hibernate.entities.Carrera;

public class CarreraMain {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSession();
        //insertarCarreras(session);
        //consulta1(session);
        //obtenerCarrerasConCaballosActivosYJinetesDTO(session);
        obtenerCarrerasConCaballosActivosYJinetesPorCiudadDTO(session);
        session.close();
    }

    private static void insertarCarreras(Session session) {

        String hql = "from CaballoCarrera";
        List<CaballoCarrera> caballos = session.createQuery(hql, CaballoCarrera.class).list();

        // Listado de carreras
        CarreraCaballosEnum[] carrerasEnum = CarreraCaballosEnum.values();
        List<Carrera> carreras = new ArrayList<>();

        session.beginTransaction();
        for (CarreraCaballosEnum carreraCaballosEnum : carrerasEnum) {
            Carrera carrera = new Carrera(
                    carreraCaballosEnum.getNombreCarrera(),
                    carreraCaballosEnum.getLugarCarrera());
            carrera.setCaballos(caballos);
            carreras.add(carrera);

            session.persist(carrera);
        }
        session.getTransaction().commit();

    }

    private static void consulta1(Session session) {
       
        List<Carrera> carreras = session.createQuery("FROM Carrera", Carrera.class).getResultList();

        for (Carrera carrera : carreras) {
            System.out.println("Carrera: " + carrera.getNombre() + " en " + carrera.getLugar());
            for (CaballoCarrera caballo : carrera.getCaballos()) {
                if (caballo.isEstaActivo()) {
                    System.out.println(
                            "  Caballo: " + caballo.getNombre() + " - Jinete: " + caballo.getJinete().getNombre());
                }
            }
        }
    }

    public static List<Object[]> obtenerCarrerasConCaballosActivosYJinetes(Session session) {
	    List<Object[]> resultados = null;
	    try {

	        String hql = "SELECT c.nombre, ca.nombre, j.nombre " +
	                     "FROM Carrera c " +
	                     "JOIN c.caballos ca " +
	                     "JOIN ca.jinete j " +
	                     "WHERE ca.estaActivo = true";
	        resultados = session.createQuery(hql, Object[].class).list();

            for (Object[] objects : resultados) {
                System.out.println("Carrera: "+objects[0] + 
                    " Caballo: "+objects[1] + 
                    " Jinete: "+objects[2] );
            }


	    } catch (Exception e) {
	        if (session.getTransaction() != null) {
	            session.getTransaction().rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }

	    return resultados;
	}


    public static void obtenerCarrerasConCaballosActivosYJinetesDTO(Session session) {
	    List<CarreraDTO> resultados = null;
	    try {

	        String hql = "SELECT new es.cursojava.hibernate.dto.CarreraDTO("+
                         "c.nombre, ca.nombre, j.nombre) " +
	                     "FROM Carrera c " +
	                     "JOIN c.caballos ca " +
	                     "JOIN ca.jinete j " +
	                     "WHERE ca.estaActivo = true";
	        resultados = session.createQuery(hql, CarreraDTO.class).list();

            for (CarreraDTO carreradto : resultados) {
                System.out.println("Carrera: "+carreradto.getNombreCarrera() + 
                    " Caballo: "+carreradto.getNombreCaballo() + 
                    " Jinete: "+carreradto.getNombreJinete() );
            }


	    } catch (Exception e) {
	        if (session.getTransaction() != null) {
	            session.getTransaction().rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }

	}


    public static void obtenerCarrerasConCaballosActivosYJinetesPorCiudadDTO(Session session) {
	    List<CarreraDTO> resultados = null;
        String ciudad = "Getafe";
	    try {

	        String hql = "SELECT new es.cursojava.hibernate.dto.CarreraDTO("+
                         "c.nombre, ca.nombre, j.nombre) " +
	                     "FROM Carrera c " +
	                     "JOIN c.caballos ca " +
	                     "JOIN ca.jinete j " +
	                     "WHERE ca.estaActivo = true " +
                         "AND c.lugar =:ciudadParam "+
                         "ORDER BY j.nombre DESC, c.nombre ASC";
            Query<CarreraDTO> query = session.createQuery(hql, CarreraDTO.class);
            query.setParameter("ciudadParam", ciudad);


	        resultados = query.list();

            for (CarreraDTO carreradto : resultados) {
                System.out.println("Carrera: "+carreradto.getNombreCarrera() + 
                    " Caballo: "+carreradto.getNombreCaballo() + 
                    " Jinete: "+carreradto.getNombreJinete() );
            }


	    } catch (Exception e) {
	        if (session.getTransaction() != null) {
	            session.getTransaction().rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }

	}
}
