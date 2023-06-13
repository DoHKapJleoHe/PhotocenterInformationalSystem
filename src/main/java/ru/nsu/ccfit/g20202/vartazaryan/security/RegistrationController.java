package ru.nsu.ccfit.g20202.vartazaryan.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.nsu.ccfit.g20202.vartazaryan.dto.RegistrationDTO;
import ru.nsu.ccfit.g20202.vartazaryan.service.UserService;

@RestController
@CrossOrigin(origins = "*")
public class RegistrationController
{
    @Autowired
    private UserService userService;

    @PostMapping("/registration")
    public void addUser(@RequestBody RegistrationDTO dto)
    {
        userService.saveUser(dto);
        System.out.println("you were registered");
    }
}
