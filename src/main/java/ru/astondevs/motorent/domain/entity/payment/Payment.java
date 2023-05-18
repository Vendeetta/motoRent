package ru.astondevs.motorent.domain.entity.payment;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.astondevs.motorent.domain.entity.BaseEntity;
import ru.astondevs.motorent.domain.entity.events.Rent;
import ru.astondevs.motorent.domain.entity.users.Customer;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "payment")
public class Payment extends BaseEntity {
    private Integer amount;
    @OneToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;
    @OneToOne
    @JoinColumn(name = "payment_id", referencedColumnName = "id")
    private Rent rent;
}
