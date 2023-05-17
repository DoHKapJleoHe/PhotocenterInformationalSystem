package ru.nsu.ccfit.g20202.vartazaryan.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.nsu.ccfit.g20202.vartazaryan.dto.PrintingOrderDTO;
import ru.nsu.ccfit.g20202.vartazaryan.mappers.PrintingOrderMapper;
import ru.nsu.ccfit.g20202.vartazaryan.service.PrintingOrderService;

import java.text.ParseException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/printing-orders")
public class PrintingController
{
    @Autowired
    private PrintingOrderService printingService;

    @GetMapping
    public List<PrintingOrderDTO> getAllOrders()
    {
        var orders = printingService.getAllOrders();

        return orders.stream().map(PrintingOrderMapper::toDTO).toList();
    }

    @GetMapping("/{id}")
    public List<PrintingOrderDTO> getOrderByClientId(@PathVariable Long id)
    {
        var orders = printingService.getOrdersByClientId(id);

        return orders.stream().map(PrintingOrderMapper::toDTO).toList();
    }

    @GetMapping("/time")
    public List<PrintingOrderDTO> getOrdersByTime(@RequestParam("dateFrom") String dateFrom, @RequestParam("dateTo") String dateTo) throws ParseException {
        System.out.println(dateFrom+" "+dateTo);

        var orders = printingService.getOrdersByDate(dateFrom, dateTo);

        return orders.stream().map(PrintingOrderMapper::toDTO).toList();
    }

    @PostMapping
    public void createOrder(@RequestBody PrintingOrderDTO dto) throws ParseException {
        System.out.println("Got printing request");
        printingService.createOrder(dto);
    }
}
