package es.cursojava.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConexionMain {
    public static void main(String[] args) {

        // // Configuración programática
        // Properties props = new Properties();
        // props.setProperty("hibernate.connection.driver_class", "oracle.jdbc.OracleDriver");
        // props.setProperty("hibernate.connection.url", "jdbc:oracle:thin:@localhost:1521/XEPDB1");
        // props.setProperty("hibernate.connection.username", "tu_usuario");
        // props.setProperty("hibernate.connection.password", "tu_contraseña");
        // props.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle12cDialect");
        // props.setProperty("hibernate.hbm2ddl.auto", "update");
        // props.setProperty("hibernate.show_sql", "true");

        // Configuration config = new Configuration();
        // config.setProperties(props);
        // config.addAnnotatedClass(Persona.class);

        SessionFactory sessionFactory;
        try {
            sessionFactory = new Configuration()
                    .configure() // Carga hibernate.cfg.xml
                    .buildSessionFactory();
            Session session = sessionFactory.openSession();
            System.out.println(session);
            
        } catch (Throwable ex) {
            System.err.println("Error al crear la SessionFactory." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        

        
        

        
    }
}
