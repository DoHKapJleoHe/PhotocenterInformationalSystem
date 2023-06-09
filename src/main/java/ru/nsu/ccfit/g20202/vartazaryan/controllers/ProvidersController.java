package ru.nsu.ccfit.g20202.vartazaryan.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.nsu.ccfit.g20202.vartazaryan.dto.DeliveryDTO;
import ru.nsu.ccfit.g20202.vartazaryan.dto.ProviderDTO;
import ru.nsu.ccfit.g20202.vartazaryan.mappers.ProviderMapper;
import ru.nsu.ccfit.g20202.vartazaryan.service.ProviderService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/providers")
public class ProvidersController
{
    @Autowired
    private ProviderService providerService;

    @GetMapping
    public List<ProviderDTO> getAllProviders()
    {
        var providers = providerService.getAllProviders();

        return providers.stream().map(ProviderMapper::toDTO).toList();
    }

    @PostMapping
    public void createProvider(@RequestBody ProviderDTO dto)
    {
        providerService.createProvider(dto);
    }

    @PostMapping("/new-resource")
    public void addResource(@RequestBody DeliveryDTO dto)
    {
        System.out.println("Got new resource request");
        providerService.makeDelivery(dto);
    }
}
