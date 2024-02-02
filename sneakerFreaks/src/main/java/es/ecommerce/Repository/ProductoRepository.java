package es.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import es.ecommerce.entity.Producto;

@Repository
public interface ProductoRepository extends CrudRepository<Producto, Long> {

}
