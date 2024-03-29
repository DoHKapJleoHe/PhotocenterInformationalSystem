package ru.nsu.ccfit.g20202.vartazaryan.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class KioskResource
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kiosk_id")
    private Kiosk kiosk;

    @ManyToOne
    @JoinColumn(name = "resource_id")
    private Resource resource;

    private Integer amount;
}
