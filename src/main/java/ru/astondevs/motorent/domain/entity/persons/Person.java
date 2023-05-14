package ru.astondevs.motorent.domain.entity.persons;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.drogunov.rent.model.entity.BaseEntity;
import ru.drogunov.rent.model.entity.address.Address;

@Getter
@Setter
@Entity(name = "person")
public class Person extends BaseEntity {
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "patronymic")
    private String patronymic;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "adress_id")
    private Address address;
}
