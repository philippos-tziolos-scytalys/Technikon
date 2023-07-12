package com.scytalys.technikon.service;

import com.scytalys.technikon.domain.User;
import com.scytalys.technikon.dto.UserDto;
import com.scytalys.technikon.exception.ExistingUserException;
import com.scytalys.technikon.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public String addUser(UserDto userDto) {
        boolean isUsernameExists = userRepository.existsByUsername(userDto.getUsername());
        boolean isEmailExists = userRepository.existsByEmail(userDto.getEmail());
        boolean isTinNumberExists = userRepository.existsByTinNumber(userDto.getTinNumber());

        if (isUsernameExists) {
            throw new ExistingUserException("Username already exists");
        }
        if (isEmailExists) {
            throw new ExistingUserException("Email already exists");
        }
        if (isTinNumberExists) {
            throw new ExistingUserException("Tin number already exists");
        }

        User user = new User(
                userDto.getTinNumber(),
                userDto.getName(),
                userDto.getLastname(),
                userDto.getAddress(),
                userDto.getNumber(),
                userDto.getUsername(),
                userDto.getEmail(),
                userDto.getPassword()
        );
        userRepository.save(user);
        return user.toString();
    }
}
