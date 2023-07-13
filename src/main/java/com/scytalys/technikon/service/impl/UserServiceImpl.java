package com.scytalys.technikon.service.impl;

import com.scytalys.technikon.domain.User;
import com.scytalys.technikon.dto.UserDto;
import com.scytalys.technikon.exception.ExistingUserException;
import com.scytalys.technikon.exception.UserNotFoundException;
import com.scytalys.technikon.mapper.UserMapper;
import com.scytalys.technikon.repository.UserRepository;
import com.scytalys.technikon.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
    @Override
    public JpaRepository<User, Long> getRepository() {
        return userRepository;
    }

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    /** Create user with validation **/
    @Override
    public UserDto createUser(UserDto userDto) {
        validateUniqueFields(userDto);

        User user = userMapper.userDtoToUser(userDto);
        User savedUser = userRepository.save(user);
        return userMapper.userToUserDto(savedUser);
    }

    /**
     * Update user
     **/
    public UserDto updateUser(UserDto userDto, Long id) {
        validateUniqueFields(userDto);

        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        user.setUsername(userDto.getUsername());
        user.setName(userDto.getName());
        user.setLastname(userDto.getLastname());
        user.setAddress(userDto.getAddress());
        user.setNumber(userDto.getNumber());
        user.setEmail(userDto.getEmail());

        User updatedUser = userRepository.save(user);
        return userMapper.userToUserDto(updatedUser);
    }

    private void validateUniqueFields(UserDto userDto) {
        boolean isUsernameExists = userRepository.existsByUsername(userDto.getUsername());
        if (isUsernameExists) {
            throw new ExistingUserException("Username already exists");
        }

        boolean isEmailExists = userRepository.existsByEmail(userDto.getEmail());
        if (isEmailExists) {
            throw new ExistingUserException("Email already exists");
        }

//        boolean isTinNumberExists = userRepository.existsByTinNumber(userDto.getTinNumber());
//        if (isTinNumberExists) {
//            throw new ExistingUserException("Tin number already exists");
//        }
    }



    /**
     * Delete user
     **/
    public void deleteUser(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isEmpty()) {
            throw new UserNotFoundException(id);
        }

        userRepository.deleteById(id);
    }


    /** Get all user **/
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    /** Get user by ID **/
    public UserDto getUserById(Long id){
        return userMapper.userToUserDto(userRepository.findById(id)
                .orElseThrow(()->new UserNotFoundException(id)));
    }
}
