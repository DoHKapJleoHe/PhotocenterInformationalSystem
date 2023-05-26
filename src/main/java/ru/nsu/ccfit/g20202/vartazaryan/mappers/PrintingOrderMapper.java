package ru.nsu.ccfit.g20202.vartazaryan.mappers;

import ru.nsu.ccfit.g20202.vartazaryan.dto.PrintingOrderDTO;
import ru.nsu.ccfit.g20202.vartazaryan.entities.PrintingOrder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
        dto.setDate(convertDateToString(printingOrder.getDate()));
        dto.setKioskNumber(printingOrder.getKioskNumber());
        dto.setClientName(printingOrder.getClient().getName());
        dto.setClientId(printingOrder.getClient().getId());

        return dto;
    }

    public static String convertDateToString(Date date)
    {
        //2023-03-13
        String str = date.toString().substring(0, 10);
        return str;
    }

    public static Date convertStringToDate(String date) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date newDate = format.parse(date);

        return newDate;
    }
}
