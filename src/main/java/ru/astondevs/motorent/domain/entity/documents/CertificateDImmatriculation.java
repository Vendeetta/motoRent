package ru.astondevs.motorent.domain.entity.documents;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.drogunov.rent.model.entity.documents.parts.VehicleInfo;
import ru.drogunov.rent.model.entity.persons.VehicleOwner;
import ru.drogunov.rent.model.entity.rent.vehicle.parts.StateNumber;

@Getter
@Setter
@Entity(name = "certificate_d_immatriculation")
public class CertificateDImmatriculation extends BaseDocument {
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id")
    private VehicleOwner owner;
    //TODO Пределать в класс есть так же в ПТС\ВУ\СРТС
    @Column(name = "special_marks")
    private String specialMarks;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "state_number_id")
    private StateNumber stateNumber;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vehicle_info")
    private VehicleInfo vehicleInfo;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "vehicle_passport_crts",
            joinColumns = @JoinColumn(name = "crts_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "vehicle_passport_id", referencedColumnName = "id")
    )
    private VehiclePassport vehiclePassport;
}
