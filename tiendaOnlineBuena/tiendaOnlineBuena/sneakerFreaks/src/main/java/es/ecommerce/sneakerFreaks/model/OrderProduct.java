package es.ecommerce.sneakerFreaks.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_product")
public class OrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido_producto")
    private Long orderProductId;

    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Product product;

    @Column(name = "cantidad_producto")
    private int quantity;

    // Constructors, getters, and setters

    public OrderProduct() {

    }

    public OrderProduct(Long orderProductId, Order order, Product product, int quantity) {
        this.orderProductId = orderProductId;
        this.order = order;
        this.product = product;
        this.quantity = quantity;
    }

    public Long getOrderProductId() {
        return orderProductId;
    }

    public void setOrderProductId(Long orderProductId) {
        this.orderProductId = orderProductId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
