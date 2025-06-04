package es.cursojava.lambdas.advanced;

import java.util.Arrays;

import es.cursojava.excepciones.ejercicio2.Cliente;
import es.cursojava.lambdas.advanced.dao.Producto;
import es.cursojava.lambdas.advanced.dao.ProductoDAO;

public class Test {

	public static void main(String[] args) {
		EjemploConsumer ec = new EjemploConsumer();
		ec.getProductos( () -> {
        	ProductoDAO pDAO = new ProductoDAO(null);
        	return pDAO.getProductos();
        } );
		
		ec.getProductos(() -> Arrays.asList(new Producto()) );
		
		
		ec.generaNombre("Jose");
		

	}
	
	public static void pintaNombreCliente(Cliente cliente) {
		System.out.println(cliente.getNombre());
	}

}
