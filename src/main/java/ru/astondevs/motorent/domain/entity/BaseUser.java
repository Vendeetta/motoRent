package ru.astondevs.motorent.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.astondevs.motorent.domain.entity.users.Role;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "users")
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
