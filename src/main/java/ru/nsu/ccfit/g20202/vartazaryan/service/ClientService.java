package ru.nsu.ccfit.g20202.vartazaryan.service;

import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nsu.ccfit.g20202.vartazaryan.dto.ClientDTO;
import ru.nsu.ccfit.g20202.vartazaryan.entities.Client;
import ru.nsu.ccfit.g20202.vartazaryan.repositories.ClientRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClientService
{
    private final ClientRepository clientRepository;

    public Client createClient(ClientDTO clientDTO)
    {
        Client newClient = Client.builder()
                .name(clientDTO.getName())
                .surname(clientDTO.getSurname())
                .type(clientDTO.getType())
                .discountCard(clientDTO.getDiscountCard())
                .build();

        return clientRepository.save(newClient);
    }

    public Client update(Client client)
    {
        return clientRepository.save(client);
    }

    public Optional<Client> getClientById(Long id)
    {
        return clientRepository.findById(id);
    }

    public List<Client> getAllClients()
    {
        return clientRepository.findAll();
    }

    public void deleteUserById(Long id)
    {
        clientRepository.deleteById(id);
    }
}
