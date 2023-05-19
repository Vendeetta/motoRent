package ru.astondevs.motorent.domain.entity.events;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.astondevs.motorent.domain.entity.BaseEntity;
import ru.astondevs.motorent.domain.entity.rent.vehicle.Vehicle;
import ru.astondevs.motorent.domain.entity.users.Customer;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "rent")
public class Rent extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "rent_customer_id")
    private Customer rentCustomer;
    @Enumerated(EnumType.STRING)
    private StatusRent status;
    @Column(name = "start_rent")
    private LocalDateTime startRent;
    @Column(name = "finish_rent")
    private LocalDateTime finishRent;
    @Column(name = "return_date")
    private LocalDateTime returnDate;

}
