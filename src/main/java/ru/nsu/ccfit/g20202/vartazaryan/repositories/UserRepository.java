package ru.nsu.ccfit.g20202.vartazaryan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nsu.ccfit.g20202.vartazaryan.entities.User;

import javax.validation.constraints.Size;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>
{
    User findByUsername(@Size(min = 2, message = "Не меньше 5 знаков") String username);
}
