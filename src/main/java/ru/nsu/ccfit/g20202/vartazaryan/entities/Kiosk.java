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
public class Kiosk
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long kioskNumber;
    private Long workplaces;

    @ManyToOne(optional = false)
    private Filial filial;

    @OneToMany(mappedBy = "kiosk")
    private List<KioskResource> resources;
}
