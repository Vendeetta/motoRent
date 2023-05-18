package ru.astondevs.motorent.service;

import ru.astondevs.motorent.domain.entity.users.BaseUser;

import java.util.List;

public interface UserService {

    BaseUser register (BaseUser user);

    List<BaseUser> getAllUsers();

    BaseUser getByUsername(String username);

    BaseUser findById(Long id);

    void delete (Long id);
}
