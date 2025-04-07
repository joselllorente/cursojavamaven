package es.cursojava.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import es.cursojava.hibernate.dto.PersonaDTO;

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

        //Usamos patrón DTO con la clase PersonaDTO
        String hql4 = "select p.nombre, p.edad from Persona p where p.edad>:edadMin";
        //Query<PersonaDTO> query4 = session.createQuery(hql4, PersonaDTO.class);
        Query<Object[]> query4 = session.createQuery(hql4, Object[].class);
        query4.setParameter("edadMin", 20);
        List<Object[]> resgistros4 = query4.list();
        List<PersonaDTO> personasDTO = new ArrayList<>();
        for (Object[] registro : resgistros4) {
            System.out.println("nombre: "+registro[0]);
            System.out.println("edad: "+registro[1]);
            String nombre = (String)registro[0];
            int edad = (int)registro[1];
            
            PersonaDTO pdto = new PersonaDTO(nombre , edad );
            personasDTO.add(pdto);
            System.out.println("======================");
        }
        System.out.println("Personas DTO en lista propia: "+personasDTO.size());

        //Usamos patrón DTO con la clase PersonaDTO mas elegante
        String hql5 = "select new es.cursojava.hibernate.dto.PersonaDTO(p.nombre, p.edad) "+
                " from Persona p where p.edad>:edadMin";
        Query<PersonaDTO> query5 = session.createQuery(hql5, PersonaDTO.class);
        query5.setParameter("edadMin", 20);
        List<PersonaDTO> resgistros5 = query5.list();
        System.out.println("Personas DTO: "+resgistros5.size());
        

    }
}

