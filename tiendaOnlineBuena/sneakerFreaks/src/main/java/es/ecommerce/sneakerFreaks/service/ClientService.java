package es.ecommerce.sneakerFreaks.service;

import es.ecommerce.sneakerFreaks.dao.ClientDAO;
import es.ecommerce.sneakerFreaks.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientDAO ClientDAO;

    @Autowired
    public ClientService(ClientDAO ClientDAO) {
        this.ClientDAO = ClientDAO;
    }

    public List<Client> getAllClients() {
        return ClientDAO.findAll();
    }

    public Client getClientById(Long id) {
        Optional<Client> optionalClient = ClientDAO.findById(id);
        return optionalClient.orElse(null);
    }

    public boolean existsById(Long id) {
        return ClientDAO.existsById(id);
    }

    public Client updateClient(Client Client) {
        return ClientDAO.save(Client);
    }

    public Client createClient(Client Client) {
        return ClientDAO.save(Client);
    }

    public void deleteClientById(Long id) {
        ClientDAO.deleteById(id);
    }
}
