package es.cursojava.lambdas;

public class Suma implements Operacion {

	private int numero;
		
	public Suma(int numero) {
		super();
		this.numero = numero;
	}

	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}

	@Override
	public int operar(int f, int g) {
		// TODO Auto-generated method stub
		return f+g;
	}
	
	

}
