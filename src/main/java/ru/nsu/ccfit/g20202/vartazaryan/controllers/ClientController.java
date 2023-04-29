package ru.nsu.ccfit.g20202.vartazaryan.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.nsu.ccfit.g20202.vartazaryan.entities.Client;
import ru.nsu.ccfit.g20202.vartazaryan.service.ClientService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/clients")
public class ClientController
{
    @Autowired
    private ClientService clientService;

    /*@GetMapping
    public List<Client> getClients()
    {

    }

    @GetMapping("/{id}")
    public Client getClientById(@PathVariable Long id)
    {

    }*/
}
