package ru.astondevs.motorent.domain.entity.events;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.astondevs.motorent.domain.entity.BaseEntity;
import ru.astondevs.motorent.domain.entity.users.Customer;
import ru.astondevs.motorent.domain.entity.rent.vehicle.Vehicle;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity(name = "rent")
public class Rent extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rent_customer_id")
    private Customer rentCustomer;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(name = "start_rent")
    private LocalDateTime startRent;
    @Column(name = "finish_rent")
    private LocalDateTime finishRent;
    @Column(name = "return_date")
    private LocalDateTime returnDate;

}
