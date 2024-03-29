package ru.nsu.ccfit.g20202.vartazaryan.mappers;

import ru.nsu.ccfit.g20202.vartazaryan.dto.KioskDTO;
import ru.nsu.ccfit.g20202.vartazaryan.entities.Kiosk;

public class KioskMapper
{
    public static KioskDTO toDTO(Kiosk kiosk)
    {
        KioskDTO kioskDTO = new KioskDTO();
        kioskDTO.setId(kiosk.getId());
        kioskDTO.setNumber(kiosk.getKioskNumber());
        kioskDTO.setWorkplaces(kiosk.getWorkplaces());
        kioskDTO.setFilialId(kiosk.getFilial().getId());

        return kioskDTO;
    }
}
