package ru.nsu.ccfit.g20202.vartazaryan.dto;


import lombok.Data;

import java.util.Date;

@Data
public class PrintingOrderDTO
{
    private Long id;
    private int numPhotos;
    private int numPhotosPerFrame;
    private String format;
    private String paperType;
    private String urgency;
    private double price;
    private String date;
    private String clientName;
    private Long clientId;
}
