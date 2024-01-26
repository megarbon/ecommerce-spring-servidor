package es.ecommerce.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPedidoProducto;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Producto producto;

    private Integer cantidad;
    private LocalDate fechaPedido;

    // Constructores, getters y setters

    public Long getIdPedidoProducto() {
        return idPedidoProducto;
    }

    public Pedido(Long idPedidoProducto, Cliente cliente, Producto producto, Integer cantidad, LocalDate fechaPedido) {
        this.idPedidoProducto = idPedidoProducto;
        this.cliente = cliente;
        this.producto = producto;
        this.cantidad = cantidad;
        this.fechaPedido = fechaPedido;
    }

    public void setIdPedidoProducto(Long idPedidoProducto) {
        this.idPedidoProducto = idPedidoProducto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        if (cliente != null) {
            cliente.getPedidosProductos().add(this);
        }
        this.cliente = cliente;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDate fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

}
