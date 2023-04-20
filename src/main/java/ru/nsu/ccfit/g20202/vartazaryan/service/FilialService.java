package ru.nsu.ccfit.g20202.vartazaryan.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nsu.ccfit.g20202.vartazaryan.dto.FilialDTO;
import ru.nsu.ccfit.g20202.vartazaryan.entities.Filial;
import ru.nsu.ccfit.g20202.vartazaryan.repositories.FilialRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class FilialService
{
    private final FilialRepository filialRepository;

    public Filial createFilial(FilialDTO filialDTO)
    {
        Filial filial = Filial.builder()
                .id(filialDTO.getId())
                .name(filialDTO.getName())
                .city(filialDTO.getCity())
                .street(filialDTO.getStreet())
                .workplaces(filialDTO.getWorkplaces())
                .build();

        return filialRepository.save(filial);
    }

    public List<Filial> getAllFilials()
    {
        return filialRepository.findAll();
    }
}
