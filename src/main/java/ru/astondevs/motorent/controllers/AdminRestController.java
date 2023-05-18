package ru.astondevs.motorent.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.astondevs.motorent.domain.entity.users.BaseUser;
import ru.astondevs.motorent.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminRestController {

    private final UserService userService;

    public AdminRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/get")
    public ResponseEntity<String> getAll(){
//        List<BaseUser> allUsers = userService.getAllUsers();
//        return ResponseEntity.ok(allUsers);
        return ResponseEntity.ok("HI, ADMIN");
    }
}
