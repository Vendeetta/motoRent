package ru.astondevs.motorent.domain.entity.documents;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.drogunov.rent.model.entity.documents.parts.VehicleInfo;
import ru.drogunov.rent.model.entity.persons.VehicleOwner;
import ru.drogunov.rent.model.entity.address.Country;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity(name = "vehicle_passport")
public class VehiclePassport extends BaseDocument {
    @ManyToOne
    @JoinColumn(name = "vehicle_info_id")
    private VehicleInfo vehicleInfo;
    private String manufacturer;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "country_export_id")
    private Country countryExport;
    @Column(name = "customs_restrictions")
    private String customsRestrictions;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "owners_vehicle_passport",
            joinColumns = @JoinColumn(name = "vehicle_passport_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "owner_id", referencedColumnName = "id"))
    private List<VehicleOwner> owners = new ArrayList<>();
    @OneToMany(cascade = CascadeType.REFRESH)
    @JoinTable(name = "vehicle_passport_crts",
            joinColumns = @JoinColumn(name = "vehicle_passport_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "crts_id", referencedColumnName = "id"))
    private List<CertificateDImmatriculation> certificateDImmatriculations;

}
