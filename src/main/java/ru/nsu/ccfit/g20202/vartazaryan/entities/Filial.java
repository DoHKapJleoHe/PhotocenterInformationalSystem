package ru.nsu.ccfit.g20202.vartazaryan.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Filial
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String city;
    private String street;
    private Long workplaces;

    @OneToMany(mappedBy = "filial")
    private List<Kiosk> kiosks;
}
