package ru.astondevs.motorent.domain.entity.users;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.astondevs.motorent.domain.entity.documents.DriverLicence;
import ru.astondevs.motorent.domain.entity.documents.PassportRF;
import ru.astondevs.motorent.domain.entity.events.Rent;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Customer extends BaseUser {
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private List<Rent> rents;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "customer_id")
    private List<DriverLicence> driverLicences;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private List<PassportRF> passportRFs;
}
