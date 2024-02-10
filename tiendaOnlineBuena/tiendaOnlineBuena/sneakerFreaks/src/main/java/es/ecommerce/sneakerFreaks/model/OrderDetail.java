package es.ecommerce.sneakerFreaks.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "detalle_pedido")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_pedido")
    private Long orderDetailId;

    // this is the id of a product in the order
    @ManyToMaOne
    @JoinColumn(name = "id_producto", columnDefinition = "Long")
    private Product product;

    // this is the units of the product in the order
    @Column(name = "unidades_producto")
    private int units;

    // El id del pedido al que pertenece el detalle
    @ManyToOne
    @JoinColumn(name = "pedido_id")
    @JsonIgnore // ❗❗ Spring Ignorará esta propiedad al serializar a JSON para evitar bucles
                // infinitos
    // Pero gracias a esto se puede mantener la referencia bidiereccional entre
    // pedido y detalles
    private Order order;

    // Constructors, getters, and setters

    public OrderDetail() {
    }

    public OrderDetail(Long orderDetailId, Product product, int units, Order order) {
        this.orderDetailId = orderDetailId;
        this.product = product;
        this.units = units;
        this.order = order;
    }

    public Long getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Long orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getunits() {
        return units;
    }

    public void setunits(int units) {
        this.units = units;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

}
