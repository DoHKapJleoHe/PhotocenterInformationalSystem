package ru.nsu.ccfit.g20202.vartazaryan.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nsu.ccfit.g20202.vartazaryan.dto.FilmingOrderDTO;
import ru.nsu.ccfit.g20202.vartazaryan.entities.FilmingOrder;
import ru.nsu.ccfit.g20202.vartazaryan.repositories.ClientRepository;
import ru.nsu.ccfit.g20202.vartazaryan.repositories.FilmingOrderRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class FilmingOrderService
{
    private FilmingOrderRepository filmingOrderRepository;
    private ClientRepository clientRepository;

    public List<FilmingOrder> getAllOrders()
    {
        return filmingOrderRepository.findAll();
    }

    public void createOrder(FilmingOrderDTO dto)
    {
        FilmingOrder filmingOrder = FilmingOrder.builder()
                .price(dto.getPrice())
                .urgency(dto.getUrgency())
                .client(clientRepository.findById(dto.getClientId()).get())
                .build();

        filmingOrderRepository.save(filmingOrder);
    }
}
