package ru.nsu.ccfit.g20202.vartazaryan.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.nsu.ccfit.g20202.vartazaryan.dto.FilialDTO;
import ru.nsu.ccfit.g20202.vartazaryan.entities.Filial;
import ru.nsu.ccfit.g20202.vartazaryan.entities.Kiosk;
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
    public List<Kiosk> getKiosks()
    {
        System.out.println("Got GET request!");
        return kioskService.getAllKiosks();
    }

    @GetMapping("/{id}")
    public Kiosk getKioskById(@PathVariable Long id)
    {
        Optional<Kiosk> kiosk = kioskService.getKioskById(id);
        System.out.println("Hi");
        return kiosk.get();
    }

    @PutMapping
    public void update()
    {

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id)
    {
        kioskService.deleteKiosk(id);
    }

    @PostMapping()
    public void create(@RequestBody FilialDTO dto)
    {
        System.out.println("Got POST request!");
        kioskService.createKiosk(dto);
    }
}
