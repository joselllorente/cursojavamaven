package es.cursojava.bbdd;

import java.util.Date;

public class Empleado {
	private int id;
	private String nombre;
	private int edad;
	private double salario;
	private int idDepartamento;
	private Date fecha_contratacion;
	
	
	public Empleado(int id, String nombre, int edad, double salario, int idDepartamento, Date fecha_contratacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.salario = salario;
		this.idDepartamento = idDepartamento;
		this.fecha_contratacion = fecha_contratacion;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public int getidDepartamento() {
		return idDepartamento;
	}
	public void setidDepartamento(int idDepartamento) {
		this.idDepartamento = idDepartamento;
	}
	public Date getFecha_contratacion() {
		return fecha_contratacion;
	}
	public void setFecha_contratacion(Date fecha_contratacion) {
		this.fecha_contratacion = fecha_contratacion;
	}
	
	

}
