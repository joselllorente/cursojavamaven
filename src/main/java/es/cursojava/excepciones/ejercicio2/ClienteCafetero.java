package es.cursojava.excepciones.ejercicio2;

import es.cursojava.excepciones.ejercicio2.excepciones.TooColdTemperatureException;
import es.cursojava.excepciones.ejercicio2.excepciones.TooHotTemperatureException;

public abstract class ClienteCafetero extends Cliente implements Cafeteable {
	
	public ClienteCafetero(String nombre) {
		super(nombre);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tomarCafe(TazaCafe tazaCafe) throws TooHotTemperatureException, TooColdTemperatureException {
		System.out.println("El cliente "+ this.getNombre() + " se va a tomar un café");
		System.out.println("El café está a "+tazaCafe.getTemperatura() + " grados");
		
		if (tazaCafe.getTemperatura() > 80) {
			TooHotTemperatureException thte = new TooHotTemperatureException("El café está ardiendo");			
			throw thte;
		} else if (tazaCafe.getTemperatura() < 20) {
			throw new TooColdTemperatureException("El café está helado");
		}else{
			System.out.println(this.getNombre() + " se está tomando el café placidamente");
		}

	}


}
