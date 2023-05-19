package ru.astondevs.motorent.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.astondevs.motorent.domain.entity.users.BaseUser;
import ru.astondevs.motorent.domain.entity.users.Role;

public interface UserRepository extends JpaRepository<BaseUser, Long> {

    BaseUser findBaseUserByUsername(String username);

    @Query("SELECT bu.role FROM BaseUser bu WHERE bu.username = :username")
    Role getBaseUserRoleByUsername(String username);
}
