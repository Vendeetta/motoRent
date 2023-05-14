package ru.astondevs.motorent.domain.entity.address;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.drogunov.rent.model.entity.BaseEntity;

@Getter
@Setter
@Entity(name = "address")
public class Address extends BaseEntity {
    //TODO Область район


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "zip_code_id")
    private ZipCode zipCode;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "country_id")
    private Country country;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id")
    private City city;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "street_id")
    private Street street;
    @Column(name = "number_home")
    private String numberHome;
    private String corpus;
    private String apartment;
}
