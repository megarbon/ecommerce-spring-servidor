package es.ecommerce.repository;
import org.springframework.data.repository.CrudRepository;

import es.ecommerce.entity.Pedido;

public interface PedidoRepository extends CrudRepository<Pedido, Long> {
    
}
