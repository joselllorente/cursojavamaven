package es.cursojava.ficheros.ejercicios;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

import es.cursojava.poo.ejercicios.alumnos.Alumno;
import es.cursojava.utils.UtilidadesFicheros;

public class Ejercicio3Ficcheros {
    public static void main(String[] args) {
        String[] asignaturas = {"A1","A2","A3"};
        Alumno a1 = new Alumno("N1", "A1", 22, 8, "asdas@asdsad.es", asignaturas);
        Alumno a2 = new Alumno("N2", "A2", 23, 6, "zxczx@asdsad.es", asignaturas);
        Alumno a3 = new Alumno("N3", "A3", 24, 9, "qweqw@asdsad.es", asignaturas);


        List<Alumno> alumnos = Arrays.asList(a1,a2,a3);
        Ejercicio3Ficcheros e3 = new Ejercicio3Ficcheros();
        e3.almacenarAlumnosFichero(alumnos);
    }

    public void almacenarAlumnosFichero (List<Alumno> alumnos){

        Path ruta = Paths.get("./recursos/datos_alumnos.txt");
		
        try {

            for (Alumno alumno : alumnos) {
                StringBuilder sb = new StringBuilder();
                sb.append(alumno.getNombre());
                sb.append(UtilidadesFicheros.SEPARADOR_PIPE);
                sb.append(alumno.getEdad());
                sb.append(UtilidadesFicheros.SEPARADOR_PIPE);
                sb.append(Arrays.toString(alumno.getAsignaturas()));

                // String contenido = ""+alumno.getNombre()+"|"+alumno.getApellidos()+
                //         "|"+alumno.getEdad() +"|" + Arrays.toString(alumno.getAsignaturas()) +"\n";
                String contenido = sb.toString();
                contenido = contenido.replace("[", "")
                            .replace("]", "");
                //N1|24|A1,A2,A3
                // String asignaturas = "";
                // for (String asignatura : alumno.getAsignaturas()) {
                //     asignaturas+=asignatura+",";
                // }
                //contenido+= asignaturas;

                Files.write(ruta, contenido.getBytes(StandardCharsets.UTF_8),
                            StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    
            }
            
            System.out.println("Escritura completada.");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
