package es.ecommerce.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class HistorialPedidos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHistorial;

    @ManyToOne
    private Pedido pedidoProducto;

    @ManyToOne
    private Cliente cliente;

    private LocalDate fechaPedido;

    // Constructores, getters y setters

    public HistorialPedidos(Long idHistorial, Pedido pedidoProducto, Cliente cliente, LocalDate fechaPedido) {
        this.idHistorial = idHistorial;
        this.pedidoProducto = pedidoProducto;
        this.cliente = cliente;
        this.fechaPedido = fechaPedido;
    }

    public Long getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(Long idHistorial) {
        this.idHistorial = idHistorial;
    }

    public Pedido getPedidoProducto() {
        return pedidoProducto;
    }

    public void setIdPedidoProducto(Long idPedidoProducto) {
        pedidoProducto.setIdPedidoProducto(idPedidoProducto) ;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setIdCliente(Long idCliente) {
        cliente.setIdCliente(idCliente);;
    }

    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDate fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

}
