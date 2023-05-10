package ru.nsu.ccfit.g20202.vartazaryan.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nsu.ccfit.g20202.vartazaryan.dto.PrintingOrderDTO;
import ru.nsu.ccfit.g20202.vartazaryan.entities.PrintingOrder;
import ru.nsu.ccfit.g20202.vartazaryan.repositories.ClientRepository;
import ru.nsu.ccfit.g20202.vartazaryan.repositories.PrintingOrderRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class PrintingOrderService
{
    private PrintingOrderRepository printingRepository;
    private ClientRepository clientRepository;

    public List<PrintingOrder> getOrdersByClientId(int id)
    {
        return null;
    }

    public List<PrintingOrder> getAllOrders()
    {
        return printingRepository.findAll();
    }

    public void createOrder(PrintingOrderDTO dto)
    {
        PrintingOrder printingOrder = PrintingOrder.builder()
                .numPhotos(dto.getNumPhotos())
                .numPhotosPerFrame(dto.getNumPhotosPerFrame())
                .format(dto.getFormat())
                .paperType(dto.getPaperType())
                .urgency(dto.getUrgency())
                .price(dto.getPrice())
                .date(dto.getDate())
                .client(clientRepository.findById(dto.getClientId()).get())
                .build();

        printingRepository.save(printingOrder);
    }
}
