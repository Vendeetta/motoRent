package ru.astondevs.motorent.controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.astondevs.motorent.domain.entity.users.BaseUser;
import ru.astondevs.motorent.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminRestController {

    private final UserService userService;

    public AdminRestController(UserService userService) {
        this.userService = userService;
    }

    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping("/getAllUsers")
    public ResponseEntity<List<BaseUser>> getAll(){
        List<BaseUser> allUsers = userService.getAllUsers();
        return ResponseEntity.ok(allUsers);
    }
}
