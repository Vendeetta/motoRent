package ru.astondevs.motorent.domain.entity.address;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import ru.astondevs.motorent.domain.entity.BaseEntity;

@Getter
@Setter
@Entity(name = "street")
public class Street extends BaseEntity {
    private String name;
}
