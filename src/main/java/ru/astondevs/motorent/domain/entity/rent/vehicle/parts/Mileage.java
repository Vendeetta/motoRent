package ru.astondevs.motorent.domain.entity.rent.vehicle.parts;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import ru.drogunov.rent.model.entity.BaseEntity;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity(name = "mileage")
public class Mileage extends BaseEntity {
    private Integer mileAge;
    private LocalDateTime fixTime;
}
