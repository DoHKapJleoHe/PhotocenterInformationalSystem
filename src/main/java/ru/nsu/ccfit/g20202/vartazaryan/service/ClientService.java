package ru.nsu.ccfit.g20202.vartazaryan.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nsu.ccfit.g20202.vartazaryan.dto.ClientDTO;
import ru.nsu.ccfit.g20202.vartazaryan.dto.UpdateDTO;
import ru.nsu.ccfit.g20202.vartazaryan.entities.Client;
import ru.nsu.ccfit.g20202.vartazaryan.repositories.ClientRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClientService
{
    private final ClientRepository clientRepository;

    public void createClient(ClientDTO clientDTO)
    {
        Client newClient = Client.builder()
                .name(clientDTO.getName())
                .surname(clientDTO.getSurname())
                .type(clientDTO.getType())
                .discountCard(clientDTO.getDiscountCard())
                .phoneNumber(clientDTO.getPhoneNumber())
                .build();

        clientRepository.save(newClient);
    }

    public void update(UpdateDTO dto)
    {
        switch (dto.getColumn())
        {
            case "Имя" -> clientRepository.updateClientNameById(dto.getValue(), dto.getId());

            case "Фамилия" -> clientRepository.updateClientSurnameById(dto.getValue(), dto.getId());

            case "Тип" -> clientRepository.updateClientTypeById(dto.getValue(), dto.getId());

            case "Скидочная карта" -> clientRepository.updateClientDiscountById(dto.getValue(), dto.getId());

            case "Номер" -> clientRepository.updateClientPhoneById(dto.getValue(), dto.getId());
        }
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

    public List<Client> getClientsByOrdersNum(Integer num)
    {
        if(num != null)
        {
            return clientRepository.findAllByOrdersNum(num);
        }
        else
        {
            return clientRepository.findAll();
        }
    }
}
