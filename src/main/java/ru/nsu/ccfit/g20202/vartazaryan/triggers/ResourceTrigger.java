package ru.nsu.ccfit.g20202.vartazaryan.triggers;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

/*@Configuration
public class ResourceTrigger
{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void init()
    {
        jdbcTemplate.execute("CREATE TRIGGER res_trigger AFTER INSERT ON printing_order ");
    }
}*/
