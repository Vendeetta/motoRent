package ru.astondevs.motorent.domain.entity.rent.vehicle.parts;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import ru.drogunov.rent.model.entity.BaseEntity;

@Getter
@Setter
@Entity(name = "code_model")
public class CodeModel extends BaseEntity {
    private String codeModel;
}
