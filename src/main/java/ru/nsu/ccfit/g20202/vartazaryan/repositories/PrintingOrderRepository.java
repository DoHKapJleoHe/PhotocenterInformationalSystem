package ru.nsu.ccfit.g20202.vartazaryan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.nsu.ccfit.g20202.vartazaryan.entities.PrintingOrder;

import java.util.List;

@Repository
public interface PrintingOrderRepository extends JpaRepository<PrintingOrder, Long>
{
    @Query("")
    List<PrintingOrder> getOrdersByClientId(int id);
}
