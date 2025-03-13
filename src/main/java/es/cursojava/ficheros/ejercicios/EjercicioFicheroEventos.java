package es.cursojava.ficheros.ejercicios;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import es.cursojava.ficheros.pojos.Evento;

public class EjercicioFicheroEventos {

    public static void main(String[] args) {
        cargarEventosFichero("Z:\\Ficheros\\eventos.txt");
    }


    private static void cargarEventosFichero(String eventsFile){
        
        try (Scanner scan = new Scanner(new File(eventsFile))) {
            scan.useDelimiter("\n");
            scan.next();
            while(scan.hasNext()) {    
                String linea = scan.next();
                String [] datos = linea.split(",");
                int id = Integer.parseInt(datos[0]);
                String nombre = datos[1];

                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                Date fecha=null;
                try {
                    fecha = format.parse(datos[2]);
                } catch (ParseException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                String lugar=datos[3];
                String descripcion=datos[4];
                int duracion = Integer.parseInt(datos[5]);
                double precio = Double.parseDouble(datos[6]);
                String organizador = datos[7];
                //boolean gratuito = Boolean.parseBoolean(datos[8]);
                boolean gratuito = datos[8].equals("true")?true:false;
                Evento evento = new Evento(id,nombre, fecha,lugar, descripcion, duracion, precio, organizador,gratuito);
                System.out.println(evento);
            }



        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }



    }


}
