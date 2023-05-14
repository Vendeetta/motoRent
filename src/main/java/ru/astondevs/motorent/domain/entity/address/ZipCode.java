package ru.astondevs.motorent.domain.entity.address;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "zip_code")
public class ZipCode {
    @Id
    @Column(name = "zip_code")
    private Integer zipCode;
}
