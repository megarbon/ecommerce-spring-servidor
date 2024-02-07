package es.ecommerce.sneakerFreaks.controller;

import es.ecommerce.sneakerFreaks.model.Client;
import es.ecommerce.sneakerFreaks.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService ClientService;

    @Autowired
    public ClientController(ClientService ClientService) {
        this.ClientService = ClientService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Client>> getAllClients() {
        try {
            List<Client> Clients = ClientService.getAllClients();
            return new ResponseEntity<>(Clients, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable("id") Long id) {
        Client Client = ClientService.getClientById(id);
        if (Client == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(Client, HttpStatus.OK);
    }

    // como siempre los metodos de insertar y modificar fallan...
    @PutMapping("/update/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable("id") Long id, @RequestBody Map<String, String> body) {
        try {
            // Obtener los campos del cuerpo de la solicitud
            String nombre = body.get("nombre");
            String correoElectronico = body.get("correoElectronico");
            String contrasena = body.get("contrasena");
            String apellidos = body.get("apellidos");
            String direccion = body.get("direccion");
            String codigoPostal = body.get("codigoPostal");
            String numeroTarjeta = body.get("numeroTarjeta");
            String fotoPerfilUrl = body.get("fotoPerfilUrl");

            // Crear un objeto Client con los datos recibidos
            Client updatedClient = new Client(id, nombre, correoElectronico, contrasena, apellidos, direccion,
                    codigoPostal, numeroTarjeta, fotoPerfilUrl);

            // Actualizar el cliente
            updatedClient = ClientService.updateClient(updatedClient);

            // Comprobar si se actualizó correctamente
            if (updatedClient != null) {
                return ResponseEntity.ok(updatedClient);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (NumberFormatException e) {
            // Manejar error de conversión de tipos
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (Exception e) {
            // Manejar otros errores
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // como siempre los metodos de insertar y modificar fallan...
    @PostMapping("/create")
    public ResponseEntity<?> createClient(@RequestBody Client client) {
        try {
            // Insertar el cliente en la base de datos
            Client createdClient = ClientService.createClient(client);

            // Devolver una respuesta con el cliente insertado y el código de estado 201
            // (CREATED)
            return ResponseEntity.status(HttpStatus.CREATED).body(createdClient);

        } catch (Exception e) {
            // Manejar cualquier excepción lanzada durante el proceso de inserción
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del servidor");
        }
    }
}
