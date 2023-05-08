package ru.nsu.ccfit.g20202.vartazaryan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.nsu.ccfit.g20202.vartazaryan.entities.Kiosk;

import java.util.List;

@Repository
public interface KioskRepository extends JpaRepository<Kiosk, Long>
{
    @Query("select k from Kiosk k where k.filial.id = :id")
    List<Kiosk> getKiosksByFilialId(@Param("id") Long id);
}