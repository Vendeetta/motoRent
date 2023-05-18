package ru.astondevs.motorent.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import ru.astondevs.motorent.domain.entity.users.BaseUser;
import ru.astondevs.motorent.domain.entity.users.Role;
import ru.astondevs.motorent.dto.AuthUserRequest;
import ru.astondevs.motorent.dto.RegisterUserRequest;
import ru.astondevs.motorent.dto.RegisterUserResponse;
import ru.astondevs.motorent.repository.UserRepository;
import ru.astondevs.motorent.security.jwt.JwtTokenProvider;
import ru.astondevs.motorent.service.UserService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class AuthenticationRestController {

    private AuthenticationManager manager;
    private JwtTokenProvider provider;
    private UserService userService;
    private UserRepository repository;

    public AuthenticationRestController(AuthenticationManager manager, JwtTokenProvider provider, UserService userService, UserRepository repository) {
        this.manager = manager;
        this.provider = provider;
        this.userService = userService;
        this.repository = repository;

    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthUserRequest authUserRequest) {
        try {
            System.out.println(authUserRequest);
            String username = authUserRequest.getUsername();
            manager.authenticate(new UsernamePasswordAuthenticationToken(username,
                    authUserRequest.getPassword()));

            BaseUser user = userService.getByUsername(username);

            if (user == null) {
                throw new UsernameNotFoundException("User with username " + username + " not found");
            }
            System.out.println(user.getRole());
            String token = provider.createToken(username, user.getRole());
            Map<Object, Object> response = new HashMap<>();
            response.put("username", username);
            response.put("token", token);
            return ResponseEntity.ok(response);
        } catch (AuthenticationException e) {
            System.out.println("Cred incorr");
            throw new BadCredentialsException("Credentials incorrect.");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterUserResponse> register(@RequestBody RegisterUserRequest request) {
        System.out.println(request);
        BaseUser user = new BaseUser();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        BaseUser savedUser = userService.register(user);
        RegisterUserResponse response = new RegisterUserResponse();
        response.setPassword(savedUser.getPassword());
        response.setUsername(savedUser.getUsername());
        response.setRole(savedUser.getRole().name());
        return ResponseEntity.ok(response);
    }
}
