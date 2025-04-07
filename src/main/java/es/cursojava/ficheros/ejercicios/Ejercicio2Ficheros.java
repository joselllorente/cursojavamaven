package es.cursojava.ficheros.ejercicios;

import java.io.File;

import es.cursojava.inicio.funciones.Utilidades;

public class Ejercicio2Ficheros {
    public static void main(String[] args) {
        //String directorio = Utilidades.pideDatoCadena("Introduce directorio");
        String directorio = "D:\\ficheros";
        File dir = new File(directorio);
        if (dir.exists() && dir.isDirectory()){
            getFiles(dir,0);

        }
    }

    private static void getFiles(File dir, int contador) {

        if (contador>=2){
            return;
        }

        //System.out.println(dir.getPath() +"\\");
        File [] files =  dir.listFiles();
        for (File file : files) {
            if (file.isFile()){
                System.out.print("\t"+file.getName() +"-");
                System.out.print("\t"+file.length() +"-");
                System.out.println("\t"+ (file.isHidden()?"Archivo oculto":"Archivo visible"));
            }else{
                System.out.println("\t"+ file.getPath() +"\\");
                getFiles(file, contador+=1);
            }
        }
    }

}
