package ru.nsu.ccfit.g20202.vartazaryan.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nsu.ccfit.g20202.vartazaryan.dto.FilmingOrderDTO;
import ru.nsu.ccfit.g20202.vartazaryan.entities.FilmingOrder;
import ru.nsu.ccfit.g20202.vartazaryan.entities.Resource;
import ru.nsu.ccfit.g20202.vartazaryan.mappers.FilmingOrderMapper;
import ru.nsu.ccfit.g20202.vartazaryan.repositories.ClientRepository;
import ru.nsu.ccfit.g20202.vartazaryan.repositories.FilmingOrderRepository;
import ru.nsu.ccfit.g20202.vartazaryan.repositories.KioskResourceRepository;
import ru.nsu.ccfit.g20202.vartazaryan.repositories.ResourceRepository;

import java.text.ParseException;
import java.util.List;

@Service
@AllArgsConstructor
public class FilmingOrderService
{
    private FilmingOrderRepository filmingOrderRepository;
    private ClientRepository clientRepository;
    private KioskResourceRepository kioskResourceRepository;
    private ResourceRepository resourceRepository;

    public List<FilmingOrder> getAllOrders()
    {
        return filmingOrderRepository.findAll();
    }

    public void createOrder(FilmingOrderDTO dto) throws ParseException
    {
        FilmingOrder filmingOrder;

        if(dto.getPhoneNumber() != null)
        {
            filmingOrder = FilmingOrder.builder()
                    .price(dto.getPrice())
                    .urgency(dto.getUrgency())
                    .date(FilmingOrderMapper.fromStringToDate(dto.getDate()))
                    .client(clientRepository.findByPhoneNumber(dto.getPhoneNumber()))
                    .build();
        }
        else
        {
            filmingOrder = FilmingOrder.builder()
                    .price(dto.getPrice())
                    .urgency(dto.getUrgency())
                    .date(FilmingOrderMapper.fromStringToDate(dto.getDate()))
                    .client(clientRepository.findById(dto.getClientId()).get())
                    .build();
        }
        filmingOrderRepository.save(filmingOrder);

        Resource res = resourceRepository.findByName("Плёнка");
        kioskResourceRepository.decreaseResourceByKioskIdAndResourceId(dto.getKioskNumber(), Math.toIntExact(res.getId()));
    }

    public List<FilmingOrder> getOrdersByClientId(Integer id)
    {
        return filmingOrderRepository.findAllByClientId(Long.valueOf(id));
    }

    public void deleteOrder(Integer id)
    {
        filmingOrderRepository.deleteById(Long.valueOf(id));
    }
}
