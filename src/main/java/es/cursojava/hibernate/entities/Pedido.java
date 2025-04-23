package es.cursojava.hibernate.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

// Insertar
// 3 clientes por cada cliente de 3-5 pedidos
// Por cada email mostrar la media de todos los pedidos, MOSTAR CON DOS DECIMALES Y CON LA SEPARACION DE LOS PUNTOS.
// En una fecha concreta mostrar el total de todos los pedidos, MOSTAR CON DOS DECIMALES Y CON LA SEPARACION DE LOS PUNTOS.
// (BUSCAR COMO FORMATEAR NUMEROS EN JAVA PARA MOSTRARLOS CON PUNTOS Y DECIMALES.)
@Entity
@Table(name = "TB_PEDIDOS", indexes = {
        @Index(name = "idx_fechaDePedido", columnList = "fechaPedido")
})
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;

    private Date fechaPedido;

    private double precioPedido;

    @ManyToOne
    @JoinColumn(name = "FK_CLIENTE")
    private Cliente cliente;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public double getPrecioPedido() {
        return precioPedido;
    }

    public void setPrecioPedido(double precioPedido) {
        this.precioPedido = precioPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Pedido() {
    }

    public Pedido(String descripcion, Date fechaPedido, double precioPedido) {
        this.descripcion = descripcion;
        this.fechaPedido = fechaPedido;
        this.precioPedido = precioPedido;
    }

}
