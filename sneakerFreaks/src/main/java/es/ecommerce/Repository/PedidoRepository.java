package es.ecommerce.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import es.ecommerce.entity.Pedido;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Long> {
    
}
