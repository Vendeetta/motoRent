package ru.astondevs.motorent.domain.entity.address;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import ru.astondevs.motorent.domain.entity.BaseEntity;

@Getter
@Setter
@Entity(name = "address")
public class Address extends BaseEntity {
    @Column(name = "country", nullable = false)
    private String country;
    @Column(name = "zip_code", nullable = false)
    private String zipCode;
    @Column(name = "region", nullable = false)
    private String region;
    private String city;
    private String street;
    @Column(name = "number_house")
    private String numberHouse;
    private String corpus;
    private String apartment;
}
