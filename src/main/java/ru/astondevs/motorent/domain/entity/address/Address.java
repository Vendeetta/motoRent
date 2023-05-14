package ru.astondevs.motorent.domain.entity.address;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.astondevs.motorent.domain.entity.BaseEntity;

@Getter
@Setter
@Entity(name = "address")
public class Address extends BaseEntity {
    private String zipCode;
    private String country;
    private String city;
    private String street;
    @Column(name = "number_home")
    private String numberHome;
    private String corpus;
    private String apartment;
}
