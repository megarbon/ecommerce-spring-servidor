package es.ecommerce.sneakerFreaks.dao;

import es.ecommerce.sneakerFreaks.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDAO extends JpaRepository<Order, Long> {
}
