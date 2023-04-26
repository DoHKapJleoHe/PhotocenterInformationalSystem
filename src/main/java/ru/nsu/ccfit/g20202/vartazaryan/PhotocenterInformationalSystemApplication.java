package ru.nsu.ccfit.g20202.vartazaryan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
public class PhotocenterInformationalSystemApplication
{
    public static void main(String[] args) 
    {
        SpringApplication.run(PhotocenterInformationalSystemApplication.class, args);
    }
}
