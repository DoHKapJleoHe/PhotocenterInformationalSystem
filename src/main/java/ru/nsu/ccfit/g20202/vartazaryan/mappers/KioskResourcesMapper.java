package ru.nsu.ccfit.g20202.vartazaryan.mappers;

import ru.nsu.ccfit.g20202.vartazaryan.dto.KioskResourcesDTO;
import ru.nsu.ccfit.g20202.vartazaryan.entities.KioskResource;

public class KioskResourcesMapper
{
    public static KioskResourcesDTO toDTO(KioskResource kr)
    {
        KioskResourcesDTO dto = new KioskResourcesDTO();
        dto.setName(kr.getResource().getName());
        dto.setAmount(kr.getAmount());

        return dto;
    }
}
