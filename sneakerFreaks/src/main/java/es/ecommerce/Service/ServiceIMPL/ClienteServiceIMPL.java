package es.ecommerce.service.serviceIMPL;

import es.ecommerce.entity.Cliente;
import es.ecommerce.repository.ClienteRepository;
import es.ecommerce.service.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceIMPL implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> listarClientes() {
        return (List<Cliente>) clienteRepository.findAll();
    }

    @Override
    public Cliente insertarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente buscarClientePorId(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    public Cliente editarCliente(Long id, String nombre, String correoElectronico, String contrasena, String apellidos,
            String direccion, String codigoPostal, String numeroTarjeta, String fotoPerfilURL) {
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        if (cliente != null) {
            cliente.setNombre(nombre);
            cliente.setCorreoElectronico(correoElectronico);
            cliente.setContrasena(contrasena);
            cliente.setApellidos(apellidos);
            cliente.setDireccion(direccion);
            cliente.setCodigoPostal(codigoPostal);
            cliente.setNumeroTarjeta(numeroTarjeta);
            cliente.setFotoPerfilURL(fotoPerfilURL);
            return clienteRepository.save(cliente);
        }
        return null;
    }

    @Override
    public void eliminarClientePorId(Long id) {
        clienteRepository.deleteById(id);
    }
}
