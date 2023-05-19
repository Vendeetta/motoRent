package ru.astondevs.motorent.service.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.astondevs.motorent.domain.entity.users.BaseUser;
import ru.astondevs.motorent.domain.entity.users.Role;
import ru.astondevs.motorent.repository.UserRepository;
import ru.astondevs.motorent.security.jwt.JwtTokenProvider;
import ru.astondevs.motorent.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    private final JwtTokenProvider provider;

    public UserServiceImpl(UserRepository userRepository, JwtTokenProvider provider) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
        this.provider = provider;
    }

    public BaseUser register(BaseUser user) {
        Role role = Role.USER;
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(role);

        BaseUser registeredUser = userRepository.save(user);
        return registeredUser;
    }

    @Override
    public List<BaseUser> getAllUsers() {
        List<BaseUser> users = userRepository.findAll();
        return users;
    }

    @Override
    public BaseUser getByUsername(String username) {
        return userRepository.findBaseUserByUsername(username);
    }

    @Override
    public BaseUser findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public String getRole(String token) {
        Jws<Claims> claimsJws = provider.decodingToken(token);
        return claimsJws.getBody().get("role").toString();
    }
}
