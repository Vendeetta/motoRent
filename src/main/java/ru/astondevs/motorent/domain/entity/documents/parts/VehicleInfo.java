package ru.astondevs.motorent.domain.entity.documents.parts;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import ru.astondevs.motorent.domain.entity.Category;

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
