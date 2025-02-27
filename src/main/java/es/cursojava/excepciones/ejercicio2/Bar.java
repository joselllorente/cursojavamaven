package es.cursojava.excepciones.ejercicio2;

import es.cursojava.excepciones.ejercicio2.excepciones.TooColdTemperatureException;
import es.cursojava.excepciones.ejercicio2.excepciones.TooHotTemperatureException;


public class Bar {
	private String nombre;
	
	public Bar(String nombre) {
		super();
		this.nombre = nombre;
	}

	public static void main(String[] args) {
		Bar bar = new Bar("Casa Lola");
		bar.abrirBar();
	}
	
	public void abrirBar() {
		System.out.println("Abriendo el bar "+ this.nombre);
		
		Huesped huesped = new Huesped("N1", "1111A");
		Comensal comensal = new Comensal("N2",true);
		ClienteAsiduo clienteAsiduo = new ClienteAsiduo("N3", "ErPesao");
		
		Cafeteable[] cafeteros = {comensal,clienteAsiduo};
		servirCafe(cafeteros);
		
	}
	
	public void servirCafe(Cafeteable[] clientes) {
		
		for (Cafeteable cliente : clientes) {
			TazaCafe taza = new TazaCafe("Arabigo");
			try {
				cliente.tomarCafe(taza);
			} catch (TooHotTemperatureException e) {
				System.out.println("El cliente se ha quemado "+e.getMessage());
				//e.printStackTrace();
			} catch (TooColdTemperatureException e) {
				System.out.println("El cliente se ha quejado "+e.getMessage());
			}
		}
		
	}
	
	
}
