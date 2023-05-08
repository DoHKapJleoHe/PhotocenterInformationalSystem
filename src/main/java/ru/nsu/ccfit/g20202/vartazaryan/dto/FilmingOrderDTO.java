package ru.nsu.ccfit.g20202.vartazaryan.dto;

import lombok.Data;

@Data
public class FilmingOrderDTO
{
    private Long id;
    private double price;
    private String urgency;
    private String clientName;
    private Long clientId;
}
