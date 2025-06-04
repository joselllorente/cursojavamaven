package es.cursojava.lambdas.advanced;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

import es.cursojava.lambdas.advanced.dao.Producto;
import es.cursojava.lambdas.advanced.dao.ProductoDAO;
import es.cursojava.lambdas.advanced.models.Usuario;

public class EjemploConsumer {
    public static void main(String[] args) {

        Consumer<Date> consumidor = fecha -> {
            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
            System.out.println(f.format(fecha));
        };
        consumidor.accept(new Date());

        BiConsumer<String, Integer> consumidorBi = 
        		(nombre, edad) -> 
        		System.out.println(nombre + ", tiene " + edad + " años!");

        consumidorBi.accept("pepe", 20);
        consumidorBi.accept("juan", 22);

        Consumer<String> consumidor2 = System.out::println;
        consumidor2.accept("Hola mundo lambda");

        List<String> nombres = Arrays.asList("andres", "pepe", "luz", "paco");
        nombres.forEach(consumidor2);

        Supplier<Usuario> creaUsuario = Usuario::new;
        Usuario usuario = creaUsuario.get();

        BiConsumer<Usuario, String> asignarNombre = Usuario::setNombre;
        asignarNombre.accept(usuario, "Andrés");
        System.out.println("Nombre usuario: " + usuario.getNombre());

        Supplier<String> proveedor = () -> "Hola mundo lambda supplier";
        
        Supplier<List<Producto>> productos = () -> {
        	ProductoDAO pDAO = new ProductoDAO(null);
        	return pDAO.getProductos();
        };

        
        System.out.println(proveedor.get());
    }
    
    public void generaNombre (String nombre) {
    	
    }
    
    public List<Producto> getProductos (Supplier<List<Producto>> c ){
    	List<Producto> productos = null;
    	
    	productos = c.get();
    	
    	return productos;
    }
    
}

