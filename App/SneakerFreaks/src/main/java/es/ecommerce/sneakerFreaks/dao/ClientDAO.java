package es.ecommerce.sneakerFreaks.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import es.ecommerce.sneakerFreaks.model.Client;

public interface ClientDAO extends JpaRepository<Client, Long> {
    // Aquí puedes añadir métodos adicionales si necesitas realizar consultas
    // personalizadas
}
