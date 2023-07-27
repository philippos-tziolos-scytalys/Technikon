package com.scytalys.technikon.service.impl;

import com.scytalys.technikon.domain.User;
import com.scytalys.technikon.dto.LoginDto;
import com.scytalys.technikon.dto.UserDto;
import com.scytalys.technikon.exception.ApiException;
import com.scytalys.technikon.repository.UserRepository;
import com.scytalys.technikon.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;


    /** Register user with validation if username or email exists */
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
        user.setRole(userDto.getRole());

        userRepository.save(user);

        return "User Registered successfully";
    }

    /** Authenticate (Login) user and returning with boolean for access */
    @Override
    public boolean authenticate(LoginDto loginDto) {
        User user = userRepository.findByEmail(loginDto.getUsername());

        return user != null && user.getPassword().equals(loginDto.getPassword());
    }
}
