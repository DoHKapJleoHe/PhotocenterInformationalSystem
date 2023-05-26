package ru.nsu.ccfit.g20202.vartazaryan.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nsu.ccfit.g20202.vartazaryan.dto.ProviderDTO;
import ru.nsu.ccfit.g20202.vartazaryan.entities.Provider;
import ru.nsu.ccfit.g20202.vartazaryan.repositories.ProviderRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ProviderService
{
    private ProviderRepository providerRepository;

    public List<Provider> getAllProviders()
    {
        return providerRepository.findAll();
    }

    public void createProvider(ProviderDTO dto)
    {
        Provider provider = Provider.builder()
                .name(dto.getName())
                .address(dto.getAddress())
                .phoneNumber(dto.getPhoneNumber())
                .build();

        providerRepository.save(provider);
    }
}
