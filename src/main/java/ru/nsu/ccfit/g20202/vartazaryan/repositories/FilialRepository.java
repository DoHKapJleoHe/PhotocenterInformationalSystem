package ru.nsu.ccfit.g20202.vartazaryan.repositories;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.nsu.ccfit.g20202.vartazaryan.entities.Filial;

@Repository
public interface FilialRepository extends JpaRepository<Filial, Long>
{
    @Transactional
    @Modifying
    @Query("UPDATE Filial f SET f.city = :city WHERE f.id = :idty")
    void updateFilialCityById(@Param("id") Integer id, @Param("city") String city);

    @Transactional
    @Modifying
    @Query("UPDATE Filial f SET f.name = :name WHERE f.id = :id")
    void updateFilialNameById(@Param("id") Integer id, @Param("name") String name);

    @Transactional
    @Modifying
    @Query("UPDATE Filial f SET f.street = :street WHERE f.id = :id")
    void updateFilialStreetById(@Param("id") Integer id, @Param("street") String street);

    @Transactional
    @Modifying
    @Query("UPDATE Filial f SET f.workplaces = :workplaces WHERE f.id = :id")
    void updateFilialWorkplacesById(@Param("id") Integer id, @Param("workplaces") Integer workplaces);
}
