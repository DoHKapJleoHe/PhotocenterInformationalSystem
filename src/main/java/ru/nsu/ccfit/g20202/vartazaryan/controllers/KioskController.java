package ru.nsu.ccfit.g20202.vartazaryan.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.nsu.ccfit.g20202.vartazaryan.dto.*;
import ru.nsu.ccfit.g20202.vartazaryan.entities.Filial;
import ru.nsu.ccfit.g20202.vartazaryan.entities.Kiosk;
import ru.nsu.ccfit.g20202.vartazaryan.mappers.KioskMapper;
import ru.nsu.ccfit.g20202.vartazaryan.mappers.KioskResourcesMapper;
import ru.nsu.ccfit.g20202.vartazaryan.service.KioskService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/kiosks")
public class KioskController
{
    @Autowired
    private KioskService kioskService;

    @GetMapping
    public List<KioskDTO> getKiosks()
    {
        System.out.println("Got GET request!");
        var kiosks = kioskService.getAllKiosks();
        return kiosks.stream().map(KioskMapper::toDTO).toList();
    }

    @GetMapping("/{id}")
    public KioskDTO getKioskById(@PathVariable Long id)
    {
        Optional<Kiosk> kiosk = kioskService.getKioskById(id);

        return KioskMapper.toDTO(kiosk.get());
    }

    @GetMapping("/kf/{id}")
    public List<KioskDTO> getKiosksByFilialId(@PathVariable Long id)
    {
        var kiosks = kioskService.getKiosksByFilialId(id);
        return kiosks.stream().map(KioskMapper::toDTO).toList();
    }

    @PutMapping
    public void update(@RequestBody UpdateDTO dto)
    {
        kioskService.update(dto);
    }

    @GetMapping("/resources/{id}")
    public List<KioskResourcesDTO> getKioskResources(@PathVariable Integer id)
    {
        var res = kioskService.getKioskResourcesById(id);

        return res.stream().map(KioskResourcesMapper::toDTO).toList();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id)
    {
        kioskService.deleteKiosk(id);
    }

    @PostMapping()
    public void create(@RequestBody KioskDTO dto)
    {
        System.out.println("Got POST request!");
        kioskService.createKiosk(dto);
    }
}
