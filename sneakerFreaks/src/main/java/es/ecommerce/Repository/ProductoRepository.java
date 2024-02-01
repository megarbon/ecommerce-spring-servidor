package es.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;

import es.ecommerce.entity.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Long> {

}
