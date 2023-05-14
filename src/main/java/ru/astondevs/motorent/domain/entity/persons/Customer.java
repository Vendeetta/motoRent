package ru.astondevs.motorent.domain.entity.persons;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "customer")
public class Customer extends Person {

}
