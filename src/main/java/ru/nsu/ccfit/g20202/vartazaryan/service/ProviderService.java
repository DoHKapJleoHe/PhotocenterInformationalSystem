package ru.nsu.ccfit.g20202.vartazaryan.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nsu.ccfit.g20202.vartazaryan.dto.DeliveryDTO;
import ru.nsu.ccfit.g20202.vartazaryan.dto.ProviderDTO;
import ru.nsu.ccfit.g20202.vartazaryan.entities.Kiosk;
import ru.nsu.ccfit.g20202.vartazaryan.entities.KioskResource;
import ru.nsu.ccfit.g20202.vartazaryan.entities.Provider;
import ru.nsu.ccfit.g20202.vartazaryan.entities.Resource;
import ru.nsu.ccfit.g20202.vartazaryan.repositories.KioskRepository;
import ru.nsu.ccfit.g20202.vartazaryan.repositories.KioskResourceRepository;
import ru.nsu.ccfit.g20202.vartazaryan.repositories.ProviderRepository;
import ru.nsu.ccfit.g20202.vartazaryan.repositories.ResourceRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ProviderService
{
    private ProviderRepository providerRepository;
    private KioskResourceRepository kioskResourceRepository;
    private KioskRepository kioskRepository;
    private ResourceRepository resourceRepository;

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

    public void makeDelivery(DeliveryDTO dto)
    {
        var amm = kioskResourceRepository.findKioskResourceByKioskIdAndResourceId(dto.getKioskId(), dto.getResourceId());

        if(amm == null)
        {
            Kiosk kiosk = kioskRepository.findById(dto.getKioskId()).get();
            Resource resource = resourceRepository.findById(Math.toIntExact(dto.getResourceId())).get();

            KioskResource kr = KioskResource.builder()
                    .kiosk(kiosk)
                    .resource(resource)
                    .amount(dto.getAmount())
                    .build();

            kioskResourceRepository.save(kr);
        }
        else
        {
            kioskResourceRepository.updateResourceInKioskByKioskResourceId(
                    Math.toIntExact(dto.getKioskId()),
                    Math.toIntExact(dto.getResourceId()),
                    dto.getAmount()
            );
        }
    }
}
