package es.cursojava.hibernate;

import java.util.List;

import org.hibernate.Session;

import es.cursojava.hibernate.entities.Autor;
import es.cursojava.hibernate.entities.Book;

public class HibernateManytoOne {
    public static void main(String[] args) {


        // Abrir sesión
        Session session = HibernateUtil.getSession();

        try {
            // Iniciar transacción
            // session.beginTransaction();

            // // Crear autor
            // Autor author = new Autor();
            // author.setName("Gabriel García Márquez");

            // // Crear libros
            // Book book1 = new Book();
            // book1.setTitle("Cien años de soledad");
            // book1.setAuthor(author); // Enlace desde el lado propietario

            // Book book2 = new Book();
            // book2.setTitle("El amor en los tiempos del cólera");
            // book2.setAuthor(author);

            // // Agregar libros al autor
            // author.getBooks().add(book1);
            // author.getBooks().add(book2);

            // // Guardar autor (Cascade.ALL guarda los libros también)
            // session.persist(author);

            // // Commit
            // session.getTransaction().commit();

            // // Nueva sesión para consultar
            
            // session.beginTransaction();

            List<Autor> authors = session.createQuery("from Autor", Autor.class).getResultList();

            for (Autor a : authors) {
                System.out.println("Autor: " + a.getName());
                for (Book b : a.getBooks()) {
                    System.out.println("  Libro: " + b.getTitle());
                }
            }

            //session.getTransaction().commit();
        } finally {
            session.close();
        }
    }
}
