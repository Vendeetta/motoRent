package ru.astondevs.motorent.domain.entity.documents.parts;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import ru.drogunov.rent.model.entity.BaseEntity;

@Getter
@Setter
@Entity(name = "vin_code")
public class VINCode extends BaseEntity {
    @Column(name = "vin_code")
    private String VINCode;
}
