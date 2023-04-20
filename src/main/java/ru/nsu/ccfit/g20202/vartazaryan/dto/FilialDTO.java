package ru.nsu.ccfit.g20202.vartazaryan.dto;

import lombok.Data;

@Data
public class FilialDTO
{
    private Long id;
    private String name;
    private String city;
    private String street;
    private Long workplaces;
}
