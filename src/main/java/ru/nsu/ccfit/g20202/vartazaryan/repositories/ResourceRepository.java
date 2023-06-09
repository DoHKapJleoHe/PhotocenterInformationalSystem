package ru.nsu.ccfit.g20202.vartazaryan.repositories;

import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nsu.ccfit.g20202.vartazaryan.entities.Resource;

@Repository

public interface ResourceRepository extends JpaRepository<Resource, Integer>
{

}
