package com.scytalys.technikon.service;

import com.scytalys.technikon.domain.User;

import java.util.List;

public interface UserService {
    User createUser(User user);

    void updateUser(User user);

    User updateUserById(User user, Long id);

    void deleteUser(Long id);

    List<User> getAllUsers();

    User getUserById(Long id);

    User getUserByTinNumber(Long tinNumber);

    User getUserByEmail(String email);

    User getUserByUsername(String username);
}
