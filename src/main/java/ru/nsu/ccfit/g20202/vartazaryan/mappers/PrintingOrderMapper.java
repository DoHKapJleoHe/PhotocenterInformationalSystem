package ru.nsu.ccfit.g20202.vartazaryan.mappers;

import ru.nsu.ccfit.g20202.vartazaryan.dto.PrintingOrderDTO;
import ru.nsu.ccfit.g20202.vartazaryan.entities.PrintingOrder;

public class PrintingOrderMapper
{
    public static PrintingOrderDTO toDTO(PrintingOrder printingOrder)
    {
        PrintingOrderDTO dto = new PrintingOrderDTO();
        dto.setId(printingOrder.getId());
        dto.setNumPhotos(printingOrder.getNumPhotos());
        dto.setNumPhotosPerFrame(printingOrder.getNumPhotosPerFrame());
        dto.setFormat(printingOrder.getFormat());
        dto.setPaperType(printingOrder.getPaperType());
        dto.setUrgency(printingOrder.getUrgency());
        dto.setPrice(printingOrder.getPrice());
        dto.setDate(printingOrder.getDate());
        dto.setClientName(printingOrder.getClient().getName());
        dto.setClientId(printingOrder.getClient().getId());

        return dto;
    }
}
