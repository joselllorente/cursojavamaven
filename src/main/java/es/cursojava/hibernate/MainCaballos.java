package es.cursojava.hibernate;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import es.cursojava.hibernate.entities.CaballoCarrera;


public class MainCaballos {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSession();
        CaballoCarrera caballo1 = new CaballoCarrera();
        caballo1.setEdad(4);
        caballo1.setNombre("Caballo1");
        caballo1.setVelocidadMaxima(20);

        CaballoCarrera caballo2 = new CaballoCarrera("Caballo2",0,30,10, 3, false);
        CaballoCarrera caballo3 = new CaballoCarrera("Caballo3",10,30,10, 3, false);
        
        List<CaballoCarrera> caballos = Arrays.asList(caballo1,caballo2,caballo3);


       
            
            System.out.println("Empieza");
            
            for (CaballoCarrera caballoCarrera : caballos) {
                Transaction tx  = session.beginTransaction();
                try{
                    System.out.println("Insertando caballo "+caballoCarrera.getNombre());
                    session.persist(caballoCarrera);
                    tx.commit();
                }catch (Exception e){
                    tx.rollback();
                    System.err.println("Error "+e);
                }
            }
            
            System.out.println("Termina");

            
        


    }
}
