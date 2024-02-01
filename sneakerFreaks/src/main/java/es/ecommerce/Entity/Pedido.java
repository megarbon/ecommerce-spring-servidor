package es.ecommerce.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Long idPedido;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @OneToMany(mappedBy = "id_pedido_producto", cascade = CascadeType.ALL)
    private List<Producto> listaProductos = new ArrayList<>();

    @Column(name = "fecha_pedido")
    private LocalDate fechaPedido;

    @Column(name = "cantidad")
    private int cantidad;

    // Constructores, getters y setters

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Producto> getlistaProductos() {
        return listaProductos;
    }

    public void setlistaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public void addProducto(Producto producto) {
        this.listaProductos.add(producto);
    }

    public void removeProducto(Producto producto) {
        this.listaProductos.remove(producto);
    }

    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDate fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return this.cantidad;
    }
}
