package es.ecommerce.sneakerFreaks.controller;

import es.ecommerce.sneakerFreaks.model.Client;
import es.ecommerce.sneakerFreaks.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<Client> updateClient(@PathVariable("id") Long id, @RequestBody Client Client) {
        try {
            Client.setId(id);
            Client updatedClient = ClientService.updateClient(Client);
            if (updatedClient != null) {
                return ResponseEntity.ok(updatedClient);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // como siempre los metodos de insertar y modificar fallan...
    @PostMapping("/create")
    public ResponseEntity<Client> createClient(@RequestBody Client Client) {
        try {
            Client createdClient = ClientService.createClient(Client);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdClient);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable("id") Long id) {
        try {
            ClientService.deleteClientById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
