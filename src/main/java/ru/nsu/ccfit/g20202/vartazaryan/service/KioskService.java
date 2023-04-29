package ru.nsu.ccfit.g20202.vartazaryan.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nsu.ccfit.g20202.vartazaryan.dto.FilialDTO;
import ru.nsu.ccfit.g20202.vartazaryan.entities.Filial;
import ru.nsu.ccfit.g20202.vartazaryan.entities.Kiosk;
import ru.nsu.ccfit.g20202.vartazaryan.repositories.KioskRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class KioskService
{
    private final KioskRepository kioskRepository;

    public List<Kiosk> getAllKiosks()
    {
        return kioskRepository.findAll();
    }

    public Optional<Kiosk> getKioskById(Long id)
    {
        return kioskRepository.findById(id);
    }

    public void deleteKiosk(Long id)
    {
        kioskRepository.deleteById(id);
    }

    public void createKiosk(FilialDTO dto)
    {

    }
}
