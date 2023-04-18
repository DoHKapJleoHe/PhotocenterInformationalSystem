package ru.nsu.ccfit.g20202.vartazaryan.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Filial
{
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String city;
    private String street;
    private Long workplaces;
}
