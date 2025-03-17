package es.cursojava.ficheros.ejercicios;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import es.cursojava.ficheros.pojos.Evento;

public class EjercicioFicheroEventos {

    public static void main(String[] args) {
        Map <String, List<Evento>> mapa = cargarEventosFichero("Z:\\Ficheros\\eventos.txt", 1);
        //pintaMapa(mapa);
        try {
            escribirEventosPorCiudad(mapa);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        mostratEventosGratuitoPorCiudad(mapa);
        System.out.println("Termina");
    }

    private static void mostratEventosGratuitoPorCiudad (Map <String, List<Evento>> mapa){
        System.out.println("============== Eventos gratuitos por ciudad ================");
        Set<String> ciudades = mapa.keySet();
        for (String ciudad : ciudades) {
            List<Evento> eventosCiudad = mapa.get(ciudad);
            for (Evento evento : eventosCiudad) {
                //System.out.println(evento);
                if (evento.isGratuito()){
                    System.out.println(ciudad + " " + evento.getNombre());
                }
            }

        }


    }

    private static void escribirEventosPorCiudad (Map <String, List<Evento>> mapa) throws IOException{
        Set<String> ciudades = mapa.keySet();
        for (String ciudad : ciudades) {
            Path ruta = Paths.get("./ciudades/"+ciudad+".txt");

            List<Evento> eventosCiudad = mapa.get(ciudad);
            System.out.println("Ciudad: "+ciudad + " con "+eventosCiudad.size());
            StringBuilder sb = new StringBuilder();
            for (Evento evento : eventosCiudad) {
                sb.append(evento.getNombre()+"\n");
            }
            Files.write(ruta, sb.toString().getBytes(StandardCharsets.UTF_8),
                StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        }

    }

    private static void pintaMapa (Map <String, List<Evento>> mapa){
        Set<String> ciudades = mapa.keySet();
        for (String ciudad : ciudades) {
            
            List<Evento> eventosCiudad = mapa.get(ciudad);
            System.out.println("Ciudad: "+ciudad + " con "+eventosCiudad.size());
            for (Evento evento : eventosCiudad) {
                System.out.println("\t"+evento.getNombre());
            }
        }
        
    }


    private static Map <String, List<Evento>> cargarEventosFichero(String eventsFile, int numLineas) {
        Map <String, List<Evento>> mapaEventos = new HashMap<>();
        
        try (Scanner scan = new Scanner(new File(eventsFile))) {
            scan.useDelimiter("\n");

            for (int i=0; i<numLineas; i++){
               scan.next();
            }

            while(scan.hasNext()) {  
                String linea = scan.next();
                String [] datos = linea.split(",");
                //StringTokenizer st = new StringTokenizer(linea,",");
                
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

                String ciudad=datos[3];
                String descripcion=datos[4];
                int duracion = Integer.parseInt(datos[5]);
                double precio = Double.parseDouble(datos[6]);
                String organizador = datos[7];
                //boolean gratuito = Boolean.parseBoolean(datos[8]);
                // String condicion = datos[8];
                // if (condicion.contains("true")){
                //     System.out.println(condicion);
                // }
                boolean gratuito = datos[8].trim().equals("true")?true:false;
                Evento evento = new Evento(id,nombre, fecha,ciudad, descripcion, duracion, precio, organizador,gratuito);
                //System.out.println(evento);

                if (mapaEventos.get(ciudad)==null){
                    List<Evento> eventosLugar = new ArrayList<>();
                    eventosLugar.add(evento);
                    mapaEventos.put(ciudad,eventosLugar);
                }else{
                    mapaEventos.get(ciudad).add(evento);
                }

            }



        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return mapaEventos;

    }


}
