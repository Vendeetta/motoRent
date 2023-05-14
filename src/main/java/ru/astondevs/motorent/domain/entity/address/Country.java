package ru.astondevs.motorent.domain.entity.address;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import ru.drogunov.rent.model.entity.BaseEntity;

@Getter
@Setter
@Entity(name = "country")
    public class Country extends BaseEntity {
    private String name;
}
