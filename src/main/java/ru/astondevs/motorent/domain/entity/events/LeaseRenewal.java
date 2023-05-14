package ru.astondevs.motorent.domain.entity.events;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.drogunov.rent.model.entity.BaseEntity;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity(name = "lease_renewal")
public class LeaseRenewal extends BaseEntity {
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rent_moto_id", referencedColumnName = "id")
    private RentMoto rentMoto;
    @Column(name = "with_date")
    private LocalDateTime withDate;
    @Column(name = "by_date")
    private LocalDateTime byDate;
}
