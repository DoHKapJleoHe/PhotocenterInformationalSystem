package ru.nsu.ccfit.g20202.vartazaryan.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.nsu.ccfit.g20202.vartazaryan.dto.ClientDTO;
import ru.nsu.ccfit.g20202.vartazaryan.dto.UpdateDTO;
import ru.nsu.ccfit.g20202.vartazaryan.mappers.ClientMapper;
import ru.nsu.ccfit.g20202.vartazaryan.service.ClientService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/clients")
public class ClientController
{
    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<ClientDTO> getAllClients()
    {
        var clients = clientService.getAllClients();

        return clients.stream().map(ClientMapper::toDTO).toList();
    }

    @GetMapping("/{num}")
    public List<ClientDTO> getClientsByOrdersNum(@PathVariable Integer num)
    {
        var clients = clientService.getClientsByOrdersNum(num);

        return clients.stream().map(ClientMapper::toDTO).toList();
    }

    @PostMapping
    public void createClient(@RequestBody ClientDTO clientDTO)
    {
        clientService.createClient(clientDTO);
    }

    @PutMapping()
    public void updateClient(@RequestBody UpdateDTO dto)
    {
        clientService.update(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id)
    {
        System.out.println("Got delete request");
        clientService.deleteUserById(id);
    }
}
