package ru.nsu.ccfit.g20202.vartazaryan.mappers;

import ru.nsu.ccfit.g20202.vartazaryan.dto.FilialDTO;
import ru.nsu.ccfit.g20202.vartazaryan.entities.Filial;

public class FilialMapper
{
    private final KioskMapper kioskMapper = new KioskMapper();

    public FilialDTO toDTO(Filial filial)
    {
        FilialDTO filialDTO = new FilialDTO();
        filialDTO.setName(filial.getName());
        filialDTO.setCity(filial.getCity());
        filialDTO.setStreet(filial.getStreet());
        filialDTO.setWorkplaces(filial.getWorkplaces());
        filialDTO.setKiosks(filial.getKiosks().stream().map(kioskMapper::toDTO).toList());

        return filialDTO;
    }
}
