package es.cursojava.inicio.funciones;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Utilidades {

	public static final String ELIGE_OPCION = "Por favor, elige una opción";
	
	public static int pideDatoNumerico(String texto) {
		System.out.println(texto);
		Scanner scan = new Scanner(System.in);
		int numero = scan.nextInt();
		
		return numero;
	}
	
	public static double pideDatoDecimal(String texto) {
		System.out.println(texto);
		Scanner scan = new Scanner(System.in);
		double numero = scan.nextInt();
		
		return numero;
	}

	/**
	 * 
	 * @param texto
	 * @return
	 */
	public static String pideDatoCadena(String texto) {
		System.out.println(texto);
		Scanner scan = new Scanner(System.in);
		String cadena = scan.nextLine();
		
		return cadena;
	}
	
	
	
	
	public static void pintaMenu (String menuStr) {
		String[] opciones = menuStr.split(";");
		pintaMenu(opciones);
		
	}
	/**
	 * Función que sirve para pintar las opciones de un menú que llegan 
	 * en un array de Strings
	 * @param menuArray Array Strings con las opciones del menú
	 * @author Jose Luis
	 * @since 1.0
	 */
	public static void pintaMenu (String[] menuArray) {
//		for (String opcion : menuArray) {
//			System.out.println(opcion);
//		}
//		System.out.println("Introduce una opción");
		pintaMenu(menuArray,"Introduce una opción");
	}
	
	public static void pintaMenu (String[] menuArray, String texto) {

		for (String opcion : menuArray) {
			System.out.println(opcion);
		}
		System.out.println(texto);
	}
	
	public static Date pideDatoDate(String texto) {
		System.out.println(texto);
		System.out.println("Ingrese una fecha con formato 'dd/MM/yyyy'");
		Scanner scan = new Scanner(System.in);
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date date = null;
		try {
			date = format.parse(scan.next());
		} catch (ParseException e) {
			System.out.println("Has introducido una fecha con formato invalido.");
		}

		return date;
	}

	public static boolean validarEmail(String email) {
		
		email = email.toLowerCase().trim();
		// email = email.replace(" ", "");
		String error = "";
		System.out.println(email.substring(email.indexOf("@") + 1));

		email.indexOf("sfs");

		if (email.contains(" ") || email.contains("\t")) {
			error += "Tiene espacio en blanco.\n";
		}
		if (email.indexOf("@") != email.lastIndexOf("@")) {
			error += "El email solo puede contener una @\n";
		}

		if (!email.contains("@")) {
			error += "El email debe contener una @\n";
		} else {// Si tienes @
			if (email.indexOf("@") > email.lastIndexOf(".")) {
				error += "Tiene que haber un punto después de la @\n";
			}else {
				String dominio = email.substring(email.indexOf("@")+1);
				if (dominio.indexOf(".") < 2) {
					error += "Tiene que haber una separación de dos o más "
							+ "caracteres entre la @ y el primer punto "
							+ "después de la @\n";
				}
				//asd.asda@s.dasfsd.ekhfykfr
				String subDominio = dominio.substring(dominio.lastIndexOf(".")+1);
				if (subDominio.length()<2 || subDominio.length()>6) {
					error += "Después del último punto  "
							+ "debe haber entre 2 y 6 caracteres\n";
				}
			}
			
			
		}

//		int contadorArrobas = 0;
//		for (int i=0; i<email.length() ; i++) {
//			char caracter = email.charAt(i);
//			if (caracter=='@') {
//				contadorArrobas++;
//			}
//		}
//		
//		if(contadorArrobas>1) {
//			error += "El email solo puede contener una @";
//		}

		if (error.isBlank()) {
			System.out.println("El email " + email + " es correcto");
			return true;
		} else {
			System.out.println("El email " + email + " es incorrecto por:\n" + error);
			return false;
		}
	}
}






