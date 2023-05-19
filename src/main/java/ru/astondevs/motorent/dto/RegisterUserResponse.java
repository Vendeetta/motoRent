package ru.astondevs.motorent.dto;

import lombok.Data;
import ru.astondevs.motorent.domain.entity.users.BaseUser;

@Data
public class RegisterUserResponse {

    private String username;
    private String password;
    private String role;

    public RegisterUserResponse(BaseUser user) {
        this.setPassword(user.getPassword());
        this.setUsername(user.getUsername());
        this.setRole(user.getRole().name());
    }
}
