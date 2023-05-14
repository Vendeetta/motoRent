package ru.astondevs.motorent.domain.entity.rent.vehicle;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.astondevs.motorent.domain.entity.BaseEntity;
import ru.astondevs.motorent.domain.entity.documents.CertificateDImmatriculation;
import ru.astondevs.motorent.domain.entity.documents.VehiclePassport;
import ru.astondevs.motorent.domain.entity.rent.vehicle.parts.Mileage;

import java.util.List;

@Getter
@Setter
@Entity(name = "vehicle")
public class Vehicle extends BaseEntity {
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vehicle_passport_id")
    private VehiclePassport vehiclePassport;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "certificate_d_immatriculation_id")
    private CertificateDImmatriculation certificateDImmatriculation;
    @OneToMany(cascade = CascadeType.ALL)
    //TODO Не правильная связь
    @JoinColumn(name = "store_mileage_id")
    private List<Mileage> storeMileage;

}
