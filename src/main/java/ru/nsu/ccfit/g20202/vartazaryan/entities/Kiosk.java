package ru.nsu.ccfit.g20202.vartazaryan.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Kiosk
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long kioskNumber;
    private Long workplaces;

    @ManyToOne
    @JoinColumn(name = "filial_id")
    private Filial filial;
}
