package ru.nsu.ccfit.g20202.vartazaryan.mappers;

import ru.nsu.ccfit.g20202.vartazaryan.dto.ProviderDTO;
import ru.nsu.ccfit.g20202.vartazaryan.entities.Provider;

public class ProviderMapper
{

    public static ProviderDTO toDTO(Provider provider)
    {
        ProviderDTO dto = new ProviderDTO();
        dto.setId(provider.getId());
        dto.setName(provider.getName());
        dto.setAddress(provider.getAddress());
        dto.setPhoneNumber(provider.getPhoneNumber());

        return dto;
    }
}
