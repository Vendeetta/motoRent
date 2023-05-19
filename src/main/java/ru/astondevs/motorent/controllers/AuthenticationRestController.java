package ru.astondevs.motorent.controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.astondevs.motorent.domain.entity.users.BaseUser;
import ru.astondevs.motorent.dto.AuthUserRequest;
import ru.astondevs.motorent.dto.RegisterUserRequest;
import ru.astondevs.motorent.dto.RegisterUserResponse;
import ru.astondevs.motorent.repository.UserRepository;
import ru.astondevs.motorent.security.jwt.JwtTokenProvider;
import ru.astondevs.motorent.service.UserService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
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

    @SecurityRequirement(name = "Bearer Authentication")
    @PostMapping("/login")
    public ResponseEntity<Map<Object, Object>> login(@RequestBody AuthUserRequest authUserRequest) {
        try {
            String username = authUserRequest.getUsername();
            manager.authenticate(new UsernamePasswordAuthenticationToken(username,
                    authUserRequest.getPassword()));

            BaseUser user = userService.getByUsername(username);

            if (user == null) {
                throw new UsernameNotFoundException("User with username " + username + " not found");
            }
            String token = provider.createToken(username, user.getRole());
            Map<Object, Object> response = new HashMap<>();
            response.put("username", username);
            response.put("token", token);
            return ResponseEntity.ok(response);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Credentials incorrect.");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterUserResponse> register(@RequestBody RegisterUserRequest request) {
        BaseUser user = new BaseUser();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        BaseUser savedUser = userService.register(user);
        RegisterUserResponse response = new RegisterUserResponse(savedUser);
        return ResponseEntity.ok(response);
    }
}
