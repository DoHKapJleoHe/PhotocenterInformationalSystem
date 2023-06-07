package ru.nsu.ccfit.g20202.vartazaryan.dto;

import lombok.Data;

@Data
public class UpdateDTO
{
    private Integer id;
    private String column;
    private String value;
}
