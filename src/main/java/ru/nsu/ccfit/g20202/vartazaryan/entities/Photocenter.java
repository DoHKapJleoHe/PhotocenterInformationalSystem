package ru.nsu.ccfit.g20202.vartazaryan.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Photocenter
{
    @Id
    @GeneratedValue
    private Long id;
}
