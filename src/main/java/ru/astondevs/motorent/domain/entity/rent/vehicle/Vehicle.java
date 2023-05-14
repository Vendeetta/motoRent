package ru.astondevs.motorent.domain.entity.rent.vehicle;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.drogunov.rent.model.entity.BaseEntity;
import ru.drogunov.rent.model.entity.documents.CertificateDImmatriculation;
import ru.drogunov.rent.model.entity.documents.VehiclePassport;
import ru.drogunov.rent.model.entity.rent.vehicle.parts.CodeModel;
import ru.drogunov.rent.model.entity.rent.vehicle.parts.Mileage;

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
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "code_model_id")
    private CodeModel codeModel;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "store_mileage_id")
    private List<Mileage> storeMileage;
    @ManyToOne
    @JoinColumn(name = "mileage_when_buyer")
    private Mileage mileageWhenBuyer;
    @Column(name = "price_buy")
    private Integer priceBuy;
    @Column(name = "additional_cost")
    private Integer additionalCost;
    @Column(name = "estimated_market_price")
    private Integer estimatedMarketPrice;

    @Override
    public String toString() {
        return priceBuy + " " + super.getId();
    }
}
