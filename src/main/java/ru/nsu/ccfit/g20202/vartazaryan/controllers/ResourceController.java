package ru.nsu.ccfit.g20202.vartazaryan.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.nsu.ccfit.g20202.vartazaryan.dto.ResourceAmountUpdateDTO;
import ru.nsu.ccfit.g20202.vartazaryan.dto.ResourceDTO;
import ru.nsu.ccfit.g20202.vartazaryan.mappers.ResourceMapper;
import ru.nsu.ccfit.g20202.vartazaryan.service.ResourceService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/resources")
public class ResourceController
{
    @Autowired
    private ResourceService resourceService;

    @PostMapping
    public void create(@RequestBody ResourceDTO dto)
    {
        resourceService.createResource(dto);
    }

    @PostMapping("/subtract-res")
    public void subtractResource(@RequestBody ResourceAmountUpdateDTO dto)
    {
        resourceService.updateResource(dto);
    }

    @GetMapping
    public List<ResourceDTO> getAllResources()
    {
        var resources = resourceService.getAllResources();

        return resources.stream().map(ResourceMapper::toDTO).toList();
    }
}
