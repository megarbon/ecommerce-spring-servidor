package es.ecommerce.sneakerFreaks.model;

import java.util.Date;
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

// Esta es la complicada. Para poder tener en sql el equivalente a una lista de
// productos en un pedido se debe hacer una tabla intermedia que relacione los
// productos con los pedidos. Esta tabla intermedia se llama OrderDetails y es en esta donde se
// debe hacer la relación de uno a muchos con Order. y es en esta tabla donde se debe hacer la referencia
// a la tabla de pedidos. (ver OrderDetail.java)

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Long orderId;

    // ✅ Relación de uno a muchos un cliente puede tener muchos pedidos
    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    private Client client;

    // ✅ Relación de uno a muchos un pedido puede tener muchos productos referencia
    // en el OrderDetail
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    // Tenemos una lista de detalles correspondientes a al pedido
    private List<OrderDetail> orderDetails;

    @Column(name = "fecha_pedido")
    private Date orderDate;

    //Constructores, getters y setters

    public Order() {
    }

    public Order(Long orderId, Client client, List<OrderDetail> orderDetails, Date orderDate) {
        this.orderId = orderId;
        this.client = client;
        this.orderDetails = orderDetails;
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

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

}
