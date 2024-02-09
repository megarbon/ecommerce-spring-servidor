package es.ecommerce.sneakerFreaks.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "id_pedido_producto", referencedColumnName = "id_pedido_producto")
    private OrderProduct orderProduct;

    /*
     * este es el código que se debe agregar para la relación de uno a muchos es
     * decir que un pedido puede tener muchos productos.
     * No funciona aun porque en la base de datos no se ha creado la relación correctamente.
     * 
     * @OneToMany(mappedBy = "order")
     * private List<OrderProduct> orderProducts;
     * 
     * 
     */

    @Column(name = "fecha_pedido")
    private Date orderDate;

    // Constructors, getters, and setters
    // Constructor vacío
    public Order() {
    }

    // Constructor con todos los atributos
    public Order(Long orderId, Client client, OrderProduct orderProduct, Date orderDate) {
        this.orderId = orderId;
        this.client = client;
        this.orderProduct = orderProduct;
        this.orderDate = orderDate;
    }

    // Getters y setters
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public OrderProduct getOrderProduct() {
        return orderProduct;
    }

    public void setOrderProduct(OrderProduct orderProduct) {
        this.orderProduct = orderProduct;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}
