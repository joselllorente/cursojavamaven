package es.cursojava.hibernate.dto;

import java.util.Date;
import java.util.List;

import es.cursojava.hibernate.entities.Pedido;

public class ClienteDTO {

    private Long id;
    private String nombre;
    private String email;
    private List<Pedido> pedidos;
    private String descripcion;
    private Date fechaPedido;
    private double precioPedido;
    private Double mediaPedidos;
    private double sumaPedidos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
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

    public Double getMediaPedidos() {
        return mediaPedidos;
    }

    public void setMediaPedidos(Double mediaPedidos) {
        this.mediaPedidos = mediaPedidos;
    }

    public double getSumaPedidos() {
        return sumaPedidos;
    }

    public void setSumaPedidos(double sumaPedidos) {
        this.sumaPedidos = sumaPedidos;
    }

    public ClienteDTO(String nombre, String email, Double mediaPedidos) {
        this.nombre = nombre;
        this.email = email;
        this.mediaPedidos = mediaPedidos;
    }

    public ClienteDTO(String email, Double mediaPedidos) {
        this.email = email;
        this.mediaPedidos = mediaPedidos;
    }

    public ClienteDTO(double sumaPedidos) {
        this.sumaPedidos = sumaPedidos;
    }

}