package ru.nsu.ccfit.g20202.vartazaryan.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Client
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String type;
    private String discountCard;
    private String phoneNumber;

    @OneToMany(mappedBy = "client")
    private List<PrintingOrder> printingOrders;
    @OneToMany(mappedBy = "client")
    private List<FilmingOrder> filmingOrders;
}
