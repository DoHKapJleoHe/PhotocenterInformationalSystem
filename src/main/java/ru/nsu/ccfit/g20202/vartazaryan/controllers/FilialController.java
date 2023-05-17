package ru.nsu.ccfit.g20202.vartazaryan.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.nsu.ccfit.g20202.vartazaryan.dto.FilialDTO;
import ru.nsu.ccfit.g20202.vartazaryan.entities.Filial;
import ru.nsu.ccfit.g20202.vartazaryan.mappers.FilialMapper;
import ru.nsu.ccfit.g20202.vartazaryan.service.FilialService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/filials")
public class FilialController
{
    @Autowired
    private FilialService filialService;

    @GetMapping
    public List<FilialDTO> getFilials()
    {
        System.out.println("Got GET request!");
        var filials = filialService.getAllFilials();

        return filials.stream().map(FilialMapper::toDTO).toList();
    }

    @GetMapping("/{id}")
    public FilialDTO getFilialById(@PathVariable Long id)
    {
        Optional<Filial> filial = filialService.getFilialById(id);
        return FilialMapper.toDTO(filial.get());
    }

    @PutMapping
    public void update(@RequestBody FilialDTO dto)
    {

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id)
    {
        filialService.deleteFilial(id);
    }

    @PostMapping()
    public void create(@RequestBody FilialDTO dto)
    {
        System.out.println("Got POST request in filial controller!");
        filialService.createFilial(dto);
    }
}