package ru.astondevs.motorent.domain.entity.users;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.astondevs.motorent.domain.entity.BaseUser;
import ru.astondevs.motorent.domain.entity.events.Rent;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Manager extends BaseUser {
    @OneToMany
    @JoinColumn(name = "manager_id", referencedColumnName = "id")
    private List<Rent> sales;
    private String position;
}
