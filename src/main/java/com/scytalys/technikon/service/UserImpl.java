package com.scytalys.technikon.service;

import com.scytalys.technikon.dto.UserDto;
import com.scytalys.technikon.exception.ExistingUserException;
import com.scytalys.technikon.mapper.UserMapper;
import com.scytalys.technikon.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserImpl implements UserService {


    private final UserRepository userRepository;

    private final UserMapper userMapper;

    @Override
    public UserDto addUser(UserDto userDto) {
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

        return userMapper.userToUserDto(userRepository.save(userMapper.userDtoToUser(userDto)));

    }
}
