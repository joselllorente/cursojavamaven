package es.cursojava.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static Session session=null;

    private static Session generateSession (){
        try {
            SessionFactory sessionFactory = new Configuration()
                    .configure() // Carga hibernate.cfg.xml
                    .buildSessionFactory();
            session = sessionFactory.openSession();
        } catch (Throwable ex) {
            System.err.println("Error al crear la SessionFactory." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        return session;
    }

    public static Session getSession() {
        if (session == null) {
            session = generateSession();
        }
       
        return session;
    }
}
