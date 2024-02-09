package es.ecommerce.sneakerFreaks.dao;

import es.ecommerce.sneakerFreaks.model.OrderProduct;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderProductDAO extends JpaRepository<OrderProduct, Long> {

}
