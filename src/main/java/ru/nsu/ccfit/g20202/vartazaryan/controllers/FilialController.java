package ru.nsu.ccfit.g20202.vartazaryan.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nsu.ccfit.g20202.vartazaryan.entities.Filial;
import ru.nsu.ccfit.g20202.vartazaryan.service.FilialService;

import java.net.http.HttpResponse;
import java.util.List;

@RequestMapping("/filials")
@RestController
public class FilialController
{
    private FilialService filialService;

    @GetMapping
    public ResponseEntity<List<Filial>> getFilials()
    {
        return new ResponseEntity<>(filialService.getAllFilials(), HttpStatus.OK);
    }
}
