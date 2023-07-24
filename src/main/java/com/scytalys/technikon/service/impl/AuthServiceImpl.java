package com.scytalys.technikon.service.impl;

import com.scytalys.technikon.domain.Role;
import com.scytalys.technikon.domain.User;
import com.scytalys.technikon.dto.LoginDto;
import com.scytalys.technikon.dto.UserDto;
import com.scytalys.technikon.exception.ApiException;
import com.scytalys.technikon.repository.RoleRepository;
import com.scytalys.technikon.repository.UserRepository;
import com.scytalys.technikon.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public String register(UserDto userDto) {
        // check if username exists
        if (userRepository.existsByUsername(userDto.getUsername())) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "username already exists.");
        }

        // check if email exists
        if (userRepository.existsByEmail(userDto.getEmail())) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "email already exists.");
        }

        User user = new User();
        user.setName(userDto.getName());
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAddress(userDto.getAddress());
        user.setLastname(userDto.getLastname());
        user.setTinNumber(userDto.getTinNumber());
        user.setPhoneNumber(userDto.getPhoneNumber());

        Set<Role> roles = new HashSet<>();
        Role roleUser = roleRepository.findByName("ROLE_USER");
        roles.add(roleUser);

        user.setRoles(roles);

        userRepository.save(user);

        return "User Registered successfully";
    }


    @Override
    public boolean authenticate(LoginDto loginDto) {
        User user = userRepository.findByEmail(loginDto.getUsername());

        return user != null && user.getPassword().equals(loginDto.getPassword());
    }
}
