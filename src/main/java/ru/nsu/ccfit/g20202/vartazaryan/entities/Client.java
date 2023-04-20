package ru.nsu.ccfit.g20202.vartazaryan.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Client
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String discount_card;
    private String name;
    private String surname;

    @OneToMany
    private List<PrintingOrder> printingOrders;
    @OneToMany
    private List<FilmingOrder> filmingOrders;
}
