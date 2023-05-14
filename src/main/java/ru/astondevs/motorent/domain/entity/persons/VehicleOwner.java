package ru.astondevs.motorent.domain.entity.persons;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.drogunov.rent.model.entity.documents.DocumentOfOwnership;
import ru.drogunov.rent.model.entity.documents.VehiclePassport;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity(name = "owner")
public class VehicleOwner extends Person {
    @Column(name = "sale_date")
    private LocalDate saleDate;
    @Column(name = "date_removal_from_the_register")
    private LocalDate dateRemovalFromTheRegister;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "document_of_ownership_id")
    private DocumentOfOwnership documentOfOwnership;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "owners_vehicle_passport",
            joinColumns = @JoinColumn(name = "owner_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "vehicle_passport_id", referencedColumnName = "id"))
    private List<VehiclePassport> vehiclePassports;
}
