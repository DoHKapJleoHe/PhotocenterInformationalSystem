package ru.nsu.ccfit.g20202.vartazaryan.mappers;

import ru.nsu.ccfit.g20202.vartazaryan.dto.ClientDTO;
import ru.nsu.ccfit.g20202.vartazaryan.entities.Client;

public class ClientMapper
{
    public static ClientDTO toDTO(Client client)
    {
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setId(client.getId());
        clientDTO.setName(client.getName());
        clientDTO.setSurname(client.getSurname());
        clientDTO.setType(client.getType());
        clientDTO.setDiscountCard(client.getDiscountCard());

        return clientDTO;
    }
}
