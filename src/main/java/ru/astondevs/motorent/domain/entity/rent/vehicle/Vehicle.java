package ru.astondevs.motorent.domain.entity.rent.vehicle;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.astondevs.motorent.domain.entity.BaseEntity;
import ru.astondevs.motorent.domain.entity.documents.CertificateDImmatriculation;
import ru.astondevs.motorent.domain.entity.documents.VehiclePassport;
import ru.astondevs.motorent.domain.entity.rent.vehicle.parts.Mileage;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "vehicle")
public class Vehicle extends BaseEntity {
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_passport_id")
    private VehiclePassport vehiclePassport;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "certificate_d_immatriculation_id")
    private CertificateDImmatriculation certificateDImmatriculation;
    @OneToMany(mappedBy = "mileage", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Mileage> mileages;

}
