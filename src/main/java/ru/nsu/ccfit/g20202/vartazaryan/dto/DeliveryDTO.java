package ru.nsu.ccfit.g20202.vartazaryan.dto;

import lombok.Data;

@Data
public class DeliveryDTO
{
    private Long kioskId;
    private Long resourceId;
    private Integer amount;
}
