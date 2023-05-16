package ru.astondevs.motorent.domain.entity.users;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.astondevs.motorent.domain.entity.address.Address;
import ru.astondevs.motorent.domain.entity.events.Rent;

import java.util.List;

@Getter
@Setter
@Entity
public class Manager extends BaseUser {
    @OneToMany
    @JoinColumn(name = "manager_id", referencedColumnName = "id")
    private List<Rent> sales;
    private String position;
}
