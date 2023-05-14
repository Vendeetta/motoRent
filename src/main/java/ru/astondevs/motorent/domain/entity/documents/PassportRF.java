package ru.astondevs.motorent.domain.entity.documents;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.drogunov.rent.model.entity.persons.RentCustomer;

import java.time.LocalDate;

@Getter
@Setter
@Entity(name = "passport_rf")
public class PassportRF extends BaseDocument {

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "rent_customer_id")
    private RentCustomer rentCustomer;
    @Column(name = "division_code")
    private String divisionCode;
    @Column(name = "birth_place")
    private String birthPlace;
    @Column(name = "birth_day")
    private LocalDate birthday;
}
