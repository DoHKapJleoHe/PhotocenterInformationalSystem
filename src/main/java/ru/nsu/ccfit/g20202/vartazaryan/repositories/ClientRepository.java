package ru.nsu.ccfit.g20202.vartazaryan.repositories;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.nsu.ccfit.g20202.vartazaryan.entities.Client;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>
{
    Client findByPhoneNumber(String phoneNumber);

    @Transactional
    @Modifying
    @Query("UPDATE Client c SET c.name = :name WHERE c.id = :id")
    void updateClientNameById(@Param("name") String name, @Param("id") Integer id);

    @Transactional
    @Modifying
    @Query("UPDATE Client c SET c.surname = :surname WHERE c.id = :id")
    void updateClientSurnameById(@Param("surname") String surname, @Param("id") Integer id);

    @Transactional
    @Modifying
    @Query("UPDATE Client c SET c.type = :type WHERE c.id = :id")
    void updateClientTypeById(@Param("type") String type, @Param("id") Integer id);

    @Transactional
    @Modifying
    @Query("UPDATE Client c SET c.discountCard = :discount WHERE c.id = :id")
    void updateClientDiscountById(@Param("discount") String discount, @Param("id") Integer id);

    @Transactional
    @Modifying
    @Query("UPDATE Client c SET c.phoneNumber = :phone WHERE c.id = :id")
    void updateClientPhoneById(@Param("phone") String phone, @Param("id") Integer id);

    // Needs correction
    @Query("SELECT c FROM Client c " +
            "LEFT JOIN PrintingOrder po ON c.id = po.client.id " +
            "LEFT JOIN FilmingOrder fo ON c.id = fo.client.id " +
            "GROUP BY c.id " +
            "HAVING COALESCE(COUNT(po), 0) + COALESCE(COUNT(fo), 0) >= :num")
    List<Client> findAllByOrdersNum(@Param("num") Integer num);
}
