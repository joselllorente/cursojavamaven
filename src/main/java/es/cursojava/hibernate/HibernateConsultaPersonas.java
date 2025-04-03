package es.cursojava.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class HibernateConsultaPersonas {
    public static void main(String[] args) {
        
        Session session = HibernateUtil.getSession();
        // Query<Persona> query = session.createQuery("from Persona", Persona.class); 
        // List<Persona> personas = query.list();

        
        // List<Persona> personas2 = session.createQuery("from Persona", Persona.class).list();
        // for (Persona persona : personas2) {
        //     System.out.println(persona);
        // }

        String hql1 = "from Persona p where p.apellidos=:nombreParametro";
        Query<Persona> query = session.createQuery(hql1, Persona.class);
        query.setParameter("nombreParametro", "APELLIDO1");
        List<Persona> personas = query.list();
        System.out.println(personas.size());
        //Persona p = query.uniqueResult();
        //System.out.println(p);


        String hql2 = "select p.nombre from Persona p where p.edad>:edadMin";
        Query<String> query2 = session.createQuery(hql2, String.class);
        query2.setParameter("edadMin", 25);
        List<String> nombres = query2.list();
        for (String nombre : nombres) {
            System.out.println(nombre);
        }

        System.out.println("3. Varios campos ======================");

        String hql3 = "select p.nombre, p.edad from Persona p where p.edad>:edadMin";
        Query<Object[]> query3 = session.createQuery(hql3, Object[].class);
        query3.setParameter("edadMin", 20);
        List<Object[]> resgistros = query3.list();
        for (Object[] registro : resgistros) {
            System.out.println("nombre: "+registro[0]);
            System.out.println("edad: "+registro[1]);
            System.out.println("======================");
        }

    }
}

