package ru.astondevs.motorent.domain.entity.users;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.astondevs.motorent.domain.entity.BaseEntity;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BaseUser extends BaseEntity {
    @Column(name = "last_name", nullable = false)
    protected String lastName;
    @Column(name = "first_name", nullable = false)
    protected String firstName;
    @Column(name = "patronymic")
    protected String patronymic;
    protected String username;
    @Column(name = "password")
    private String password;
    protected String email;
    @Enumerated(EnumType.STRING)
    protected Role role;
}
