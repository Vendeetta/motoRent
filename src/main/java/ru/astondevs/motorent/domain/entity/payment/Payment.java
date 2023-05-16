package ru.astondevs.motorent.domain.entity.payment;

import jakarta.persistence.*;
import ru.astondevs.motorent.domain.entity.BaseEntity;
import ru.astondevs.motorent.domain.entity.events.Rent;
import ru.astondevs.motorent.domain.entity.users.Customer;

import java.util.List;


@Entity
@Table(name = "payment")
public class Payment extends BaseEntity {
    private Integer amount;
    @OneToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;
    @OneToMany
    @JoinColumn(name = "payment_id", referencedColumnName = "id")
    private List<Rent> rent;
}
