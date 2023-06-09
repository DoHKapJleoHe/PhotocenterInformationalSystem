package ru.nsu.ccfit.g20202.vartazaryan.dto;

import lombok.Data;

@Data
public class NewOrderDTO
{
    private Integer kioskId;
    private String urgency;
    private Integer numPhotos;
    private Integer numPhotosPerFrame;
    private String paperFormat;
    private String paperType;
    private String date;
    private Integer price;
}
