package ru.nsu.ccfit.g20202.vartazaryan.repositories;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.nsu.ccfit.g20202.vartazaryan.entities.KioskResource;

import java.util.List;

@Repository
public interface KioskResourceRepository extends JpaRepository<KioskResource, Integer>
{
    KioskResource findKioskResourceByKioskIdAndResourceId(Long kiosk_id, Long resource_id);

    @Transactional
    @Modifying
    @Query("UPDATE KioskResource kr SET kr.amount=:amount WHERE kr.kiosk.id=:kiosk_id AND kr.resource.id=:resource_id")
    void updateResourceInKioskByKioskResourceId(
            @Param("kiosk_id") Integer kioskId,
            @Param("resource_id") Integer resourceId,
            @Param("amount") Integer amount);

    List<KioskResource> findAllByKiosk_Id(Long kiosk_id);
}
