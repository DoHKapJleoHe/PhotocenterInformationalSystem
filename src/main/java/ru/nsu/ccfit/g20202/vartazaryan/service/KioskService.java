package ru.nsu.ccfit.g20202.vartazaryan.service;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nsu.ccfit.g20202.vartazaryan.dto.FilialDTO;
import ru.nsu.ccfit.g20202.vartazaryan.dto.KioskDTO;
import ru.nsu.ccfit.g20202.vartazaryan.entities.Filial;
import ru.nsu.ccfit.g20202.vartazaryan.entities.Kiosk;
import ru.nsu.ccfit.g20202.vartazaryan.repositories.FilialRepository;
import ru.nsu.ccfit.g20202.vartazaryan.repositories.KioskRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class KioskService
{
    private final KioskRepository kioskRepository;
    private final FilialRepository filialRepository;

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

    public List<Kiosk> getKiosksByFilialId(Long id)
    {
        return kioskRepository.getKiosksByFilialId(id);
    }

    public void createKiosk(KioskDTO dto)
    {
        var filial = filialRepository.findById(dto.getFilialId());
        //Make check if filial_id is incorrect
        Kiosk kiosk = Kiosk.builder()
                .kioskNumber(dto.getNumber())
                .workplaces(dto.getWorkplaces())
                .filial(filial.get())
                .build();

        kioskRepository.save(kiosk);
    }
}
