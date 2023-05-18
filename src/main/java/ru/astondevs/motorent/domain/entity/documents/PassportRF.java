package ru.astondevs.motorent.domain.entity.documents;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.astondevs.motorent.domain.entity.BaseDocument;
import ru.astondevs.motorent.domain.entity.address.Address;
import ru.astondevs.motorent.domain.entity.users.Customer;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "passport_rf")
public class PassportRF extends BaseDocument {

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Customer user;
    @Column(name = "division_code")
    private String divisionCode;
    @Column(name = "birth_place")
    private String birthPlace;
    @Column(name = "birth_day")
    private LocalDate birthday;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "adress_id", referencedColumnName = "id")
    private Address addressRegister;
}
