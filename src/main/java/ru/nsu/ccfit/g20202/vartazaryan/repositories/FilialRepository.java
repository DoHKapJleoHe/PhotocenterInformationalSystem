package ru.nsu.ccfit.g20202.vartazaryan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nsu.ccfit.g20202.vartazaryan.entities.Filial;

@Repository
public interface FilialRepository extends JpaRepository<Filial, Long>
{
}
