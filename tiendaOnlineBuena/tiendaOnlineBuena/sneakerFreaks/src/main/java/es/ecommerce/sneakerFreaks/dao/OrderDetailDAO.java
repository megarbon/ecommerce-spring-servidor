package es.ecommerce.sneakerFreaks.dao;

import org.springframework.stereotype.Repository;

import es.ecommerce.sneakerFreaks.model.OrderDetail;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface OrderDetailDAO extends JpaRepository<OrderDetail, Long>{
    
}
