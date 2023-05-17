package ru.nsu.ccfit.g20202.vartazaryan.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.nsu.ccfit.g20202.vartazaryan.dto.FilmingOrderDTO;
import ru.nsu.ccfit.g20202.vartazaryan.mappers.FilmingOrderMapper;
import ru.nsu.ccfit.g20202.vartazaryan.service.FilmingOrderService;

import java.text.ParseException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/filming-orders")
public class FilmingController
{
    @Autowired
    private FilmingOrderService filmingOrderService;

    @GetMapping
    public List<FilmingOrderDTO> getAllOrders()
    {
        var orders = filmingOrderService.getAllOrders();

        return orders.stream().map(FilmingOrderMapper::toDTO).toList();
    }

    @PostMapping
    public void createOrder(@RequestBody FilmingOrderDTO dto) throws ParseException
    {
        filmingOrderService.createOrder(dto);
    }
}
