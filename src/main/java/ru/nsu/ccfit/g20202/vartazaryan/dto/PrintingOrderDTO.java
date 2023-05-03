package ru.nsu.ccfit.g20202.vartazaryan.dto;

// what date should i use: java.util oa java.sql ??
import java.util.Date;

public class PrintingOrderDTO
{
    private int numPhotos;
    private int numPhotosPerFrame;
    private String format;
    private String paperType;
    private String urgency;
    private double price;
    private Date date;
    private String done;
}
