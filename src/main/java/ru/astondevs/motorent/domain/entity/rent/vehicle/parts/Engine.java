package ru.astondevs.motorent.domain.entity.rent.vehicle.parts;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;
import ru.astondevs.motorent.domain.entity.BaseEntity;
import ru.astondevs.motorent.domain.entity.rent.vehicle.TypeEngine;

@Getter
@Setter
@Entity(name = "engine")
public class Engine extends BaseEntity {
    private String model;
    private String number;
    @Column(name = "power_hors")
    private Integer powerHors;
    @Column(name = "power_kvt")
    private Integer powerKVT;
    @Column(name = "working_volume")
    private Integer workingVolume;
    @Enumerated(EnumType.STRING)
    private TypeEngine typeEngine;
}
