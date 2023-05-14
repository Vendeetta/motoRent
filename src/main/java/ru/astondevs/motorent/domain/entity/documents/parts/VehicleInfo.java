package ru.astondevs.motorent.domain.entity.documents.parts;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.astondevs.motorent.domain.entity.Category;
import ru.astondevs.motorent.domain.entity.rent.vehicle.parts.Engine;

import java.time.Year;

@Getter
@Setter
@Entity(name = "vehicle_info")
public class VehicleInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String VINCode;
    private String mark;
    private String color;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "engine_id")
    private Engine engine;
    @Column(name = "year")
    private Year year;
    @Enumerated(EnumType.STRING)
    private Category category;
    @Column(name = "type")
    private String type;
    private String chassis;
    private String body;
    @Column(name = "special_marks")
    private String specialMarks;
    @Column(name = "max_mass")
    private Integer maxMass;
    @Column(name = "netto_mass")
    private Integer nettoMass;

}
