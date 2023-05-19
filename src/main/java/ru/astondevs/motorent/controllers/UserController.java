package ru.astondevs.motorent.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.astondevs.motorent.service.UserService;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    private UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/healthCheck")
    public String hello() {
        return "Hello, World";
    }

    @GetMapping("/role")
    public ResponseEntity<String> getRole(@RequestHeader(name = "Authorization") String token) {
        return ResponseEntity.ok(service.getRole(token));
    }
}
