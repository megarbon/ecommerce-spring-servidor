package es.ecommerce.Repository;
import org.springframework.data.repository.CrudRepository;
import es.ecommerce.Entity.Pedido;

public interface PedidoRepository extends CrudRepository<Pedido, Long> {
    
}
