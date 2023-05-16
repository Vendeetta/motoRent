package ru.astondevs.motorent.domain.entity.documents;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import ru.astondevs.motorent.domain.entity.documents.parts.VehicleInfo;

@Getter
@Setter
@Entity(name = "vehicle_passport")
public class VehiclePassport extends BaseDocument {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_info_id")
    private VehicleInfo vehicleInfoId;
    private String manufacturer;
    private String countryExport;
    @Column(name = "customs_restrictions")
    private String customsRestrictions;
    private String owner;

}
