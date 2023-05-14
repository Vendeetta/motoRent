package ru.astondevs.motorent.domain.entity.persons;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.astondevs.motorent.domain.entity.documents.DriverLicence;
import ru.astondevs.motorent.domain.entity.documents.PassportRF;
import ru.astondevs.motorent.domain.entity.events.RentMoto;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity(name = "rent_customer")
public class RentCustomer extends Customer {
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private final List<RentMoto> rentMoto = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "rent_customer_id")
    private final List<DriverLicence> driverLicences = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "rent_customer_id", referencedColumnName = "id")
    private final List<PassportRF> passportRFs = new ArrayList<>();

    public void setDriverLicences(List<DriverLicence> list) {
        driverLicences.addAll(list);
    }

    public void addDriverLicence(DriverLicence driverLicence) {
        driverLicences.add(driverLicence);
    }

    public void setPassportRFs(List<PassportRF> list) {
        passportRFs.addAll(list);
    }

    public void addPassportRF(PassportRF passport) {
        passportRFs.add(passport);
    }

}
