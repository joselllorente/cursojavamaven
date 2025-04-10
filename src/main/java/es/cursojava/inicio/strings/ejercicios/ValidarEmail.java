package es.cursojava.inicio.strings.ejercicios;

public class ValidarEmail {

	public static void main(String[] args) {
		// asdasd@asd ase.es
		// asdasd@asdasees
		// asdasd@asda@se.es
		getError();

	}

	private static void getError() {
		String email = "   asdasd@asqweasd  ";
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
		} else {
			System.out.println("El email " + email + " es incorrecto por:\n" + error);
		}
	}

}
