package ru.nsu.ccfit.g20202.vartazaryan.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nsu.ccfit.g20202.vartazaryan.dto.ResourceAmountUpdateDTO;
import ru.nsu.ccfit.g20202.vartazaryan.dto.ResourceDTO;
import ru.nsu.ccfit.g20202.vartazaryan.entities.Resource;
import ru.nsu.ccfit.g20202.vartazaryan.repositories.KioskResourceRepository;
import ru.nsu.ccfit.g20202.vartazaryan.repositories.ResourceRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ResourceService
{
    private ResourceRepository resourceRepository;
    private KioskResourceRepository kioskResourceRepository;

    public void createResource(ResourceDTO dto)
    {
        Resource resource = Resource.builder()
                .name(dto.getName())
                .build();

        resourceRepository.save(resource);
    }

    public List<Resource> getAllResources()
    {
        return resourceRepository.findAll();
    }

    public void updateResource(ResourceAmountUpdateDTO dto)
    {
        System.out.println("Subtracting...");
    }
}
