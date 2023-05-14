package ru.astondevs.motorent.domain.entity.documents;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.astondevs.motorent.domain.entity.documents.parts.VehicleInfo;
import java.util.List;

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
