package es.ecommerce.sneakerFreaks.dao;

import es.ecommerce.sneakerFreaks.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDAO extends JpaRepository<Product, Long> {
}
