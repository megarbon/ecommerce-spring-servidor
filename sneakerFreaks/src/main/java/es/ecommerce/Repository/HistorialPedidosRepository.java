package es.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import es.ecommerce.entity.HistorialPedidos;

@Repository
public interface HistorialPedidosRepository extends CrudRepository<HistorialPedidos, Long> {

}
