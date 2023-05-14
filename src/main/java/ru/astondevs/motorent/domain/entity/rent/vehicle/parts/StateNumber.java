package ru.astondevs.motorent.domain.entity.rent.vehicle.parts;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import ru.drogunov.rent.model.entity.BaseEntity;

@Getter
@Setter
@Entity(name = "state_number")
public class StateNumber extends BaseEntity {
    private String numbers;
    private String letters;
    private String region;
}
