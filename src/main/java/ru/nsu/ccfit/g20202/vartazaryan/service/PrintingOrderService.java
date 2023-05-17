package ru.nsu.ccfit.g20202.vartazaryan.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nsu.ccfit.g20202.vartazaryan.dto.PrintingOrderDTO;
import ru.nsu.ccfit.g20202.vartazaryan.entities.PrintingOrder;
import ru.nsu.ccfit.g20202.vartazaryan.mappers.PrintingOrderMapper;
import ru.nsu.ccfit.g20202.vartazaryan.repositories.ClientRepository;
import ru.nsu.ccfit.g20202.vartazaryan.repositories.PrintingOrderRepository;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class PrintingOrderService
{
    private PrintingOrderRepository printingRepository;
    private ClientRepository clientRepository;

    public List<PrintingOrder> getOrdersByClientId(Long id)
    {
        return printingRepository.findPrintingOrderByClientId(id);
    }

    public List<PrintingOrder> getAllOrders()
    {
        return printingRepository.findAll();
    }

    public void createOrder(PrintingOrderDTO dto) throws ParseException {
        PrintingOrder printingOrder = PrintingOrder.builder()
                .numPhotos(dto.getNumPhotos())
                .numPhotosPerFrame(dto.getNumPhotosPerFrame())
                .format(dto.getFormat())
                .paperType(dto.getPaperType())
                .urgency(dto.getUrgency())
                .price(dto.getPrice())
                .date(PrintingOrderMapper.convertStringToDate(dto.getDate()))
                .client(clientRepository.findById(dto.getClientId()).get())
                .build();

        printingRepository.save(printingOrder);
    }

    public List<PrintingOrder> getOrdersByDate(String dateFrom, String dateTo) throws ParseException
    {
        if(dateFrom.equals("") || dateTo.equals(""))
        {
            return printingRepository.findAll();
        }
        else
        {
            Date date1 = PrintingOrderMapper.convertStringToDate(dateFrom);
            Date date2 = PrintingOrderMapper.convertStringToDate(dateTo);

            return printingRepository.findPrintingOrderByDateBetween(date1, date2);
        }
    }
}
