package ru.astondevs.motorent.domain.entity.rent.vehicle.parts;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.astondevs.motorent.domain.entity.BaseEntity;
import ru.astondevs.motorent.domain.entity.rent.vehicle.Vehicle;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "mileage")
public class Mileage extends BaseEntity {
    private Integer mileage;
    @Column(name = "fix_time")
    private LocalDateTime fixTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

}
