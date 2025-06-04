package es.cursojava.lambdas.advanced.dao;

public class ProductosInfo {
	private String tipo;
	private double mediaPrecio;
	private long totalProductos;
	private double maxPrecio;
	
//	public ProductosInfo() {
//		
//	}
	
	public ProductosInfo(double mediaPrecio, long totalProductos, String tipo) {
		super();
		this.tipo = tipo;
		this.mediaPrecio = mediaPrecio;
		this.totalProductos = totalProductos;
	}
	
	public ProductosInfo(String tipo, double mediaPrecio, long totalProductos, double maxPrecio) {
		super();
		this.tipo = tipo;
		this.mediaPrecio = mediaPrecio;
		this.totalProductos = totalProductos;
		this.maxPrecio = maxPrecio;
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
	 * @return the mediaPrecio
	 */
	public double getMediaPrecio() {
		return mediaPrecio;
	}

	/**
	 * @param mediaPrecio the mediaPrecio to set
	 */
	public void setMediaPrecio(double mediaPrecio) {
		this.mediaPrecio = mediaPrecio;
	}

	/**
	 * @return the totalProductos
	 */
	public long getTotalProductos() {
		return totalProductos;
	}

	/**
	 * @param totalProductos the totalProductos to set
	 */
	public void setTotalProductos(long totalProductos) {
		this.totalProductos = totalProductos;
	}

	/**
	 * @return the maxPrecio
	 */
	public double getMaxPrecio() {
		return maxPrecio;
	}

	/**
	 * @param maxPrecio the maxPrecio to set
	 */
	public void setMaxPrecio(double maxPrecio) {
		this.maxPrecio = maxPrecio;
	}

	@Override
	public String toString() {
		return "ProductosInfo [" + (tipo != null ? "tipo=" + tipo + ", " : "") + "mediaPrecio=" + mediaPrecio
				+ ", totalProductos=" + totalProductos + ", maxPrecio=" + maxPrecio + "]";
	}
	
	
	
	
}
