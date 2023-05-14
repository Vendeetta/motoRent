package ru.astondevs.motorent.domain.entity.address;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import ru.drogunov.rent.model.entity.BaseEntity;

@Getter
@Setter
@Entity(name = "city")
public class City extends BaseEntity {
    private String name;
}
