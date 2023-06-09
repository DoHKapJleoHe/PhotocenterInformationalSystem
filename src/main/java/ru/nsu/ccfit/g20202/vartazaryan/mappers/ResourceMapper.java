package ru.nsu.ccfit.g20202.vartazaryan.mappers;

import ru.nsu.ccfit.g20202.vartazaryan.dto.ResourceDTO;
import ru.nsu.ccfit.g20202.vartazaryan.entities.Resource;

public class ResourceMapper
{
    public static ResourceDTO toDTO(Resource resource)
    {
        ResourceDTO dto = new ResourceDTO();
        dto.setId(resource.getId());
        dto.setName(resource.getName());

        return dto;
    }
}
