package ru.astondevs.motorent.domain.entity.events;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.drogunov.rent.model.entity.BaseEntity;
import ru.drogunov.rent.model.entity.persons.RentCustomer;
import ru.drogunov.rent.model.entity.rent.vehicle.Vehicle;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity(name = "rent_moto")
public class RentMoto extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rent_customer_id")
    private RentCustomer rentCustomer;
    @Column(name = "start_rent")
    private LocalDateTime startRent;
    @Column(name = "finish_rent")
    private LocalDateTime finishRent;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "rent_moto_id")
    private final List<LeaseRenewal> leaseRenewals = new ArrayList<>();
    @Column(name = "return_date")
    private LocalDateTime returnDate;

    public void setLeaseRenewals(List<LeaseRenewal> collections) {
        leaseRenewals.addAll(collections);
    }
}
