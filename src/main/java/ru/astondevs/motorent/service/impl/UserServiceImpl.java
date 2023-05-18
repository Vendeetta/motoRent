package ru.astondevs.motorent.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.astondevs.motorent.domain.entity.users.BaseUser;
import ru.astondevs.motorent.domain.entity.users.Role;
import ru.astondevs.motorent.repository.UserRepository;
import ru.astondevs.motorent.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
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
}
