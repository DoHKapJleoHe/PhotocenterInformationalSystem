package ru.nsu.ccfit.g20202.vartazaryan.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FilmingOrder
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double price;
    private String urgency;
    private Date date;
    private int kioskNumber;

    @ManyToOne(optional = false)
    private Client client;
}
