package ru.nsu.ccfit.g20202.vartazaryan.mappers;

import ru.nsu.ccfit.g20202.vartazaryan.dto.FilmingOrderDTO;
import ru.nsu.ccfit.g20202.vartazaryan.entities.FilmingOrder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FilmingOrderMapper
{
    public static FilmingOrderDTO toDTO(FilmingOrder order)
    {
        FilmingOrderDTO dto = new FilmingOrderDTO();
        dto.setId(order.getId());
        dto.setPrice(order.getPrice());
        dto.setUrgency(order.getUrgency());
        dto.setDate(convertDateToString(order.getDate()));
        dto.setClientName(order.getClient().getName());
        dto.setClientId(order.getClient().getId());
        dto.setKioskNumber(order.getKioskNumber());

        return dto;
    }

    public static String convertDateToString(Date date)
    {
        //2023-03-13
        String str = date.toString().substring(0, 10);
        return str;
    }

    public static Date fromStringToDate(String date) throws ParseException
    {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date newDate = format.parse(date);

        return newDate;
    }
}
