package ru.nsu.ccfit.g20202.vartazaryan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nsu.ccfit.g20202.vartazaryan.entities.FilmingOrder;

import java.util.List;

@Repository
public interface FilmingOrderRepository extends JpaRepository<FilmingOrder, Long>
{
    List<FilmingOrder> findAllByClientId(Long client_id);
}
