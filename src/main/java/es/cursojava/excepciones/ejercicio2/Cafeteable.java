package es.cursojava.excepciones.ejercicio2;

import es.cursojava.excepciones.ejercicio2.excepciones.TooColdTemperatureException;
import es.cursojava.excepciones.ejercicio2.excepciones.TooHotTemperatureException;

public interface Cafeteable {
    void tomarCafe(TazaCafe taza) throws TooHotTemperatureException, TooColdTemperatureException;
}
