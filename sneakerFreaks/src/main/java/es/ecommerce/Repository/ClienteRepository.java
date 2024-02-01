package es.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;

import es.ecommerce.entity.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {

}
