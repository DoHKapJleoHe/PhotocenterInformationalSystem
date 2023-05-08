package ru.nsu.ccfit.g20202.vartazaryan.mappers;

import ru.nsu.ccfit.g20202.vartazaryan.dto.FilialDTO;
import ru.nsu.ccfit.g20202.vartazaryan.entities.Filial;

public class FilialMapper
{
    public static FilialDTO toDTO(Filial filial)
    {
        FilialDTO filialDTO = new FilialDTO();
        filialDTO.setId(filial.getId());
        filialDTO.setName(filial.getName());
        filialDTO.setCity(filial.getCity());
        filialDTO.setStreet(filial.getStreet());
        filialDTO.setWorkplaces(filial.getWorkplaces());

        return filialDTO;
    }
}
