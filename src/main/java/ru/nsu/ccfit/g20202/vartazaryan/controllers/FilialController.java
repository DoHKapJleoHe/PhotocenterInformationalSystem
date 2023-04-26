package ru.nsu.ccfit.g20202.vartazaryan.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nsu.ccfit.g20202.vartazaryan.dto.FilialDTO;
import ru.nsu.ccfit.g20202.vartazaryan.entities.Filial;
import ru.nsu.ccfit.g20202.vartazaryan.service.FilialService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/filials")
public class FilialController
{
    @Autowired
    private FilialService filialService;

    @GetMapping
    public List<Filial> getFilials()
    {
        System.out.println("Got GET request!");
        return filialService.getAllFilials();
    }

    @GetMapping("/{id}")
    public Filial getFilialById(@PathVariable Long id)
    {
        Optional<Filial> filial = filialService.getFilialById(id);
        System.out.println("Hi");
        return filial.get();
    }

    @PostMapping()
    public Filial create(@RequestBody FilialDTO dto)
    {
        System.out.println("Got POST request!");
        return filialService.createFilial(dto);
    }
}
