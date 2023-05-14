package ru.astondevs.motorent.domain.entity.documents;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.astondevs.motorent.domain.entity.documents.parts.VehicleInfo;

@Getter
@Setter
@Entity(name = "certificate_d_immatriculation")
public class CertificateDImmatriculation extends BaseDocument {
    private Long ownerId;
    @Column(name = "special_marks")
    private String specialMarks;
    private String stateNumber;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_info")
    private VehicleInfo vehicleInfoId;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "vehicle_passport_crts",
            joinColumns = @JoinColumn(name = "crts_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "vehicle_passport_id", referencedColumnName = "id")
    )
    private VehiclePassport vehiclePassport;
}
