package es.cursojava.ficheros.ejercicios;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.cursojava.utils.UtilidadesFicheros;

public class Ejercicio1Ficheros {
    private static final Logger logger = LoggerFactory.getLogger(Ejercicio1Ficheros.class);
    private static final String DIR_DOCUMENTOS = "documentos";
    private static final String DIR_IMAGENES = "imagenes";
    private static final String DIR_OTROS = "otros";
    public static void main(String[] args) {
        String dirOrigen = "C:\\Users\\Tardes\\Ficheros\\";
        File dirFicheros = new File(dirOrigen);

        if (dirFicheros.exists()){
            logger.info("El directorio "+ dirOrigen + " existe. Creando nuevos directorios si no existieran");

            String [] directorios = {DIR_DOCUMENTOS, DIR_IMAGENES, DIR_OTROS};
            UtilidadesFicheros.crearDirectorios(dirFicheros, directorios);
        }


        // for (int i = 0; i < 5; i++) {
        //     String nombreFichero = Utilidades.pideDatoCadena("Introduce nombre del fichero "+ (i+1));
        //     String extensionFichero = nombreFichero.substring(nombreFichero.lastIndexOf("."));
        //     logger.info("La extension del fichero "+ nombreFichero +" es " +extensionFichero);
        //     String directorioDestino = "";
        //     if (extensionFichero.equals(".txt")){
        //         directorioDestino = dirOrigen+DIR_DOCUMENTOS;
        //     }
        //     else if (extensionFichero.equals(".jpg") || extensionFichero.equals(".png")){
        //         directorioDestino = dirOrigen+DIR_IMAGENES;
        //     }else{
        //         directorioDestino = dirOrigen+DIR_OTROS;
        //     }

        //     File ficheroDocumento = new File(directorioDestino, nombreFichero);
        //     try {
        //         ficheroDocumento.createNewFile();
        //         logger.info("Fichero "+ ficheroDocumento +" creado correctamente");
        //     } catch (IOException e) {
        //         logger.error("Fichero "+ ficheroDocumento +" no creado por "+e.getMessage());
        //     }
        // }


        File dirOtros = new File(dirOrigen+DIR_OTROS);
        File[] ficherosOtros = dirOtros.listFiles();
        int contador = 0;
        for (File fichero : ficherosOtros) {
            if (fichero.isFile()){
                String extensionFichero = "";
                if (fichero.getName().contains(".")){
                    extensionFichero = fichero.getName().substring(fichero.getName().lastIndexOf("."));
                }else{
                    extensionFichero = ".xml";
                }
                
                String nuevoNombre = "joseluis"+contador+extensionFichero;
                File fileRenamed = new File (dirOtros,nuevoNombre);
                fichero.renameTo(fileRenamed);
                contador++;
            }
        }
    }
    
}
