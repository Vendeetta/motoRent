package ru.astondevs.motorent.dto;

import lombok.Data;

@Data
public class RegisterUserResponse {

    private String username;
    private String password;
    private String role;
}
