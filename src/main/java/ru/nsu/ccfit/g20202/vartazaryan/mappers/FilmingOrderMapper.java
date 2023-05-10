package ru.nsu.ccfit.g20202.vartazaryan.mappers;

import ru.nsu.ccfit.g20202.vartazaryan.dto.FilmingOrderDTO;
import ru.nsu.ccfit.g20202.vartazaryan.entities.FilmingOrder;

public class FilmingOrderMapper
{
    public static FilmingOrderDTO toDTO(FilmingOrder order)
    {
        FilmingOrderDTO dto = new FilmingOrderDTO();
        dto.setId(order.getId());
        dto.setPrice(order.getPrice());
        dto.setUrgency(order.getUrgency());
        dto.setClientName(order.getClient().getName());
        dto.setClientId(order.getClient().getId());

        return dto;
    }
}
