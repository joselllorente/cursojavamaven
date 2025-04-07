package es.cursojava.ficheros;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmpezandoConFicheros {
    private static final Logger logger = LoggerFactory.getLogger(EmpezandoConFicheros.class);
    public static void main(String[] args) {
        File directorio = new File("C:\\Users\\Tardes\\Ficheros");
        File fichero = new File("C:\\Users\\Tardes\\Ficheros\\fichero1.txt");
        
        System.out.println(directorio.isDirectory());
        System.out.println(directorio.isFile());

        System.out.println(fichero.isDirectory());
        System.out.println(fichero.isFile());
        System.out.println(fichero.exists());

        for (int i = 0; i < 10; i++) {
            File directorioNuevo = new File (directorio,"\\subdir"+i);
            directorioNuevo.mkdir();
        }
        System.out.println("=========================================");
        String[] lista = directorio.list();
        for (String nombre : lista) {
            System.out.println(nombre);
            File file1 = new File(directorio,nombre);
            file1.delete();
        }

        File [] ficheros = directorio.listFiles();
        for (File file : ficheros) {
            System.out.println(file.delete());
        }

        System.out.println("=========================================");
        File fichero2 = new File("C:\\Users\\Tardes\\Ficherosss\\fichero2.txt");
        try {
            fichero2.createNewFile();
        } catch (IOException e) {
            logger.error("Error al crear el fichero "+ fichero2.getAbsolutePath() + ": " + e.getMessage(), e);
        }


    }
}
