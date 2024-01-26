package es.ecommerce.Repository;

import org.springframework.data.repository.CrudRepository;
import es.ecommerce.Entity.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {

}
