package ru.nsu.ccfit.g20202.vartazaryan.dto;

import lombok.Data;

import java.util.List;

@Data
public class FilialDTO
{
    private Long id;
    private String name;
    private String city;
    private String street;
    private Long workplaces;
}
