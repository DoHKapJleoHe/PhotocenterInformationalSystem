package ru.nsu.ccfit.g20202.vartazaryan.dto;

import lombok.Data;

@Data
public class ClientDTO
{
    private Long id;
    private String name;
    private String surname;
    private String type;
    private String discountCard;
    private String phoneNumber;
}
