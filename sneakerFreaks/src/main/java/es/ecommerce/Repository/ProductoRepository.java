package es.ecommerce.Repository;

import org.springframework.data.repository.CrudRepository;
import es.ecommerce.Entity.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Long> {

}
