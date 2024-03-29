package ru.nsu.ccfit.g20202.vartazaryan.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PrintingOrder
{
    //Наверное стоит добавить поле киоск, в котором был сделан заказ
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int numPhotos;
    private int numPhotosPerFrame;
    private String format;
    private String paperType;
    private String urgency;
    private double price;
    private Date date;
    private int kioskNumber;

    @ManyToOne(optional = false)
    private Client client;
}
