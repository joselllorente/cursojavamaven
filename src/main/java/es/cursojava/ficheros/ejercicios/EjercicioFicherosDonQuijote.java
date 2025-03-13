package es.cursojava.ficheros.ejercicios;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class EjercicioFicherosDonQuijote {
    public static void main(String[] args) {
        EjercicioFicherosDonQuijote efdq = new EjercicioFicherosDonQuijote();
        efdq.leerArchivo("Z:\\Ficheros\\Quijote.txt");
    }

    public int leerArchivo(String nombre) {
		Path path = Paths.get(nombre);
		int contador = 0;
        int contadorQuijote = 0;
        try{
            
		    List<String> lines = Files.readAllLines(path);
            for (String linea : lines) {
                contador++;
                String [] palabras = linea.split(" ");
                //asdasd asdas Quijote! asdd asdasd Quijote asda  asd Quijote
                for (String palabra : palabras) {
                    if (palabra.toLowerCase().contains("quijote")){
                        contadorQuijote++;
                    }    
                }
                
            }
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
		

		System.out.println("Num lineas: "+contador);
        System.out.println("Num lineas quijote: "+contadorQuijote);
        return contador;
	}
}
