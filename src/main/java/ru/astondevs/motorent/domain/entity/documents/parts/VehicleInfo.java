package ru.astondevs.motorent.domain.entity.documents.parts;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.astondevs.motorent.domain.entity.BaseEntity;
import ru.astondevs.motorent.domain.entity.CategoryDriversLicence;

import java.time.Year;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "vehicle_info")
public class VehicleInfo extends BaseEntity {
    @Column(name = "vin_code")
    private String VINCode;
    private String mark;
    private String color;
    private String model;
    private String number;
    @Column(name = "power_hors")
    private Integer powerHors;
    @Column(name = "power_kvt")
    private Integer powerKVT;
    @Column(name = "working_volume")
    private Integer workingVolume;
    @Column(name = "type_engine")
    private String typeEngine;
    @Column(name = "year")
    private Year year;
    @Enumerated(EnumType.STRING)
    private CategoryDriversLicence category;
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
