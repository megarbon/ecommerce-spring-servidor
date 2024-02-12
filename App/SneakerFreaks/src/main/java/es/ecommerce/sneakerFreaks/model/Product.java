package es.ecommerce.sneakerFreaks.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

    /** Unique id for the product. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto", nullable = false)
    private Long id;
    /** The name of the product. */
    @Column(name = "nombre", nullable = false, unique = true)
    private String name;
    /** The short description of the product. */
    @Column(name = "descripcion", nullable = false)
    private String description;
    /** The price of the product. */
    @Column(name = "precio", nullable = false)
    private Double price;
    /** The stock of the product. */
    @Column(name = "stock", nullable = false)
    private Double stock;
    /** The images of the product. */
    @Column(name = "imagen_url", nullable = false)
    private String image_url;

    public Product(Long id, String name, String description, Double price, Double stock, String image_url) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.image_url = image_url;
    }

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getdescription() {
        return description;
    }

    public void setdescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getStock() {
        return stock;
    }

    public void setStock(Double stock) {
        this.stock = stock;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

}
