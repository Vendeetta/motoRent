package ru.astondevs.motorent.domain.entity.rent.vehicle.parts;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import ru.drogunov.rent.model.entity.BaseEntity;

@Getter
@Setter
@Entity(name = "color")
public class Color extends BaseEntity{
    private String name;
    @Column(name = "hex")
    private String HEX;
    private String rgb;
}
