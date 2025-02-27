package es.cursojava.excepciones.ejercicio2;

public class Comensal extends ClienteCafetero{
    private boolean tieneReserva;

    public Comensal(String nombre, boolean tieneReserva) {
        super(nombre);
        this.tieneReserva = tieneReserva;
    }

    public boolean isTieneReserva() {
        return tieneReserva;
    }

	// @Override
	// public void tomarCafe(TazaCafe taza) throws TooHotTemperatureException, TooColdTemperatureException{
	// 	if (taza.getTemperatura()>80){
	// 		throw new TooHotTemperatureException("La taza de café está muy caliente "+ taza.getTemperatura());
	// 	}else if (taza.getTemperatura()<20){
	// 		throw new TooColdTemperatureException("La taza de café está muy fria "+ taza.getTemperatura());
	// 	}
	// 	else{
	// 		System.out.println(this.getNombre() + " se está tomando el café a " + taza.getTemperatura() + "grados placidamente");
	// 	}
		
	// }

    
    
}
