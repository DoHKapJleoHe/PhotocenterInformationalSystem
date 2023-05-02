package ru.nsu.ccfit.g20202.vartazaryan.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.nsu.ccfit.g20202.vartazaryan.service.ClientService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/clients")
public class ClientController
{
    @Autowired
    private ClientService clientService;
}
