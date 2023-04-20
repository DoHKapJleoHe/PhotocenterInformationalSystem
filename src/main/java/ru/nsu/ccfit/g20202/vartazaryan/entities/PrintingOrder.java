package ru.nsu.ccfit.g20202.vartazaryan.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class PrintingOrder
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Client client;
    private int numPhotos;
    private int numPhotosPerFrame;
    private String format;
    private String paperType;
    private String urgency;
    private double price;
    private Date date;
    private String done;
}
