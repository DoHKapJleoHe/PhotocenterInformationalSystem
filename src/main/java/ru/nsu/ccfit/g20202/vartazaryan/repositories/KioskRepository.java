package ru.nsu.ccfit.g20202.vartazaryan.repositories;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.nsu.ccfit.g20202.vartazaryan.entities.Filial;
import ru.nsu.ccfit.g20202.vartazaryan.entities.Kiosk;

import java.util.List;

@Repository
public interface KioskRepository extends JpaRepository<Kiosk, Long>
{
    @Query("SELECT k FROM Kiosk k WHERE k.filial.id = :id")
    List<Kiosk> getKiosksByFilialId(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query("UPDATE Kiosk k SET k.kioskNumber = :value WHERE k.id = :id")
    void updateNumberById(@Param("id") Integer id, @Param("value") Integer value);

    @Transactional
    @Modifying
    @Query("UPDATE Kiosk k SET k.workplaces = :value WHERE k.id = :id")
    void updateWorkplacesById(@Param("id") Integer id, @Param("value") Integer value);

    @Transactional
    @Modifying
    @Query("UPDATE Kiosk k SET k.filial = :value WHERE k.id = :id")
    void updateFilialById(@Param("id") Integer id, @Param("value") Filial value);
}