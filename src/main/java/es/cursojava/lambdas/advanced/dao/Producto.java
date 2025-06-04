package es.cursojava.lambdas.advanced.dao;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="TB_PRODUCTOS")
public class Producto {

	@Id
	@SequenceGenerator(name="PRODUCTOGEN", sequenceName="PRODUCTO_GEN", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRODUCTOGEN")
	private long id;
	@Column(length = 20) 
	private String nombre;
	@Column(length = 20)
	private String tipo;
	@Column(length = 20, name="Fecha_Alta")
	private Date fechaAlta;
	@Column(length = 5, precision = 2)
	private double precio;
	@Column(length = 3)
	private int unidades;
	
	
	public Producto() {
		super();
	}

	public Producto(String nombre, String tipo, Date fechaAlta, double precio, int unidades) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.fechaAlta = fechaAlta;
		this.precio = precio;
		this.unidades = unidades;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the fechaAlta
	 */
	public Date getFechaAlta() {
		return fechaAlta;
	}

	/**
	 * @param fechaAlta the fechaAlta to set
	 */
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	/**
	 * @return the precio
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/**
	 * @return the unidades
	 */
	public int getUnidades() {
		return unidades;
	}

	/**
	 * @param unidades the unidades to set
	 */
	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", " + (nombre != null ? "nombre=" + nombre + ", " : "")
				+ (tipo != null ? "tipo=" + tipo + ", " : "")
				+ (fechaAlta != null ? "fechaAlta=" + fechaAlta + ", " : "") + "precio=" + precio + ", unidades="
				+ unidades + "]";
	}
	
	
	
	
}
