package es.ecommerce.controller;

import es.ecommerce.entity.Cliente;
import es.ecommerce.service.serviceIMPL.ClienteServiceIMPL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteServiceIMPL clienteService;

    @GetMapping("/consultar")
    public ResponseEntity<List<Cliente>> consultarClientes() {
        List<Cliente> listaClientes = clienteService.listarClientes();
        return ResponseEntity.ok(listaClientes);
    }

    @PostMapping("/insertar")
    public ResponseEntity<Cliente> insertarCliente(@RequestBody Cliente cliente) {
        Cliente clienteInsertado = clienteService.insertarCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteInsertado);
    }

    @GetMapping("/consultar/{id}")
    public ResponseEntity<?> consultarClientePorId(@PathVariable Long id) {
        Cliente cliente = clienteService.buscarClientePorId(id);
        if (cliente != null) {
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado");
        }
    }

    @PutMapping("/modificar/{id}")
    public ResponseEntity<Cliente> modificarCliente(@PathVariable Long id, @RequestBody Cliente clienteModificado) {
        Cliente clienteActualizado = clienteService.editarCliente(
                id,
                clienteModificado.getNombre(),
                clienteModificado.getCorreoElectronico(),
                clienteModificado.getContrasena(),
                clienteModificado.getApellidos(),
                clienteModificado.getDireccion(),
                clienteModificado.getCodigoPostal(),
                clienteModificado.getNumeroTarjeta(),
                clienteModificado.getFotoPerfilURL());

        if (clienteActualizado != null) {
            return ResponseEntity.ok(clienteActualizado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarCliente(@PathVariable Long id) {
        clienteService.eliminarClientePorId(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/hola")
    public ResponseEntity<String> holaMundo() {
        return ResponseEntity.ok("¡Hola Mundo!");
    }
}
