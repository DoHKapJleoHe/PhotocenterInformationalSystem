package ru.nsu.ccfit.g20202.vartazaryan.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nsu.ccfit.g20202.vartazaryan.dto.FilialDTO;
import ru.nsu.ccfit.g20202.vartazaryan.entities.Filial;
import ru.nsu.ccfit.g20202.vartazaryan.repositories.FilialRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FilialService
{
    private final FilialRepository filialRepository;

    public void createFilial(FilialDTO filialDTO)
    {
        Filial filial = Filial.builder()
                .name(filialDTO.getName())
                .city(filialDTO.getCity())
                .street(filialDTO.getStreet())
                .workplaces(filialDTO.getWorkplaces())
                .build();

        filialRepository.save(filial);
    }

    public void deleteFilial(Long id)
    {
        filialRepository.deleteById(id);
    }

    public Filial update(Filial filial)
    {
        return filialRepository.save(filial);
    }

    public Optional<Filial> getFilialById(Long id)
    {
        return filialRepository.findById(id);
    }

    public List<Filial> getAllFilials()
    {
        return filialRepository.findAll();
    }
}
