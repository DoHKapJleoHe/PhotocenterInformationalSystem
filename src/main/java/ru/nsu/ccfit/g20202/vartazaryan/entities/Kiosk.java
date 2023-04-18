package ru.nsu.ccfit.g20202.vartazaryan.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Kiosk
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long workplaces;

    @ManyToOne
    @JoinColumn(name = "filial_id", referencedColumnName = "id")
    private Filial filial;
}
