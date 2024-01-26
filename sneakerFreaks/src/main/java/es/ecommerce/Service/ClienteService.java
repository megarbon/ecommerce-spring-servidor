package es.ecommerce.Service;

import es.ecommerce.Entity.Cliente;

import java.util.List;

public interface ClienteService {

    List<Cliente> listarClientes();

    Cliente insertarCliente(Cliente cliente);

    Cliente buscarClientePorId(Long id);

    Cliente editarCliente(Long id, String nombre, String correoElectronico, String contrasena, String apellidos,
            String direccion, String codigoPostal, String numeroTarjeta, String fotoPerfilURL);

    void eliminarClientePorId(Long id);
}
