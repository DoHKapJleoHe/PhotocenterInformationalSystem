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

/*
* <div>
                <h2>Филиалы</h2>
                <table>
                    <thead>
                        <th>ID</th>
                        <th>Name</th>
                        <th>City</th>
                        <th>Street</th>
                        <th>Workplaces</th>
                    </thead>
                    <tbody>
                    {this.state.filialData.map(filial => (
                        <tr key={filial.id}>
                            <td>{filial.id}</td>
                            <td>{filial.name}</td>
                            <td>{filial.city}</td>
                            <td>{filial.workplaces}</td>
                        </tr>
                    ))}
                    </tbody>
                </table>
            </div>*/