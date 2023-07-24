package com.scytalys.technikon.service.impl;

import com.scytalys.technikon.domain.User;
import com.scytalys.technikon.encryption.PasswordEncryption;
import com.scytalys.technikon.exception.ExistingUserException;
import com.scytalys.technikon.exception.UserNotFoundException;
import com.scytalys.technikon.repository.UserRepository;
import com.scytalys.technikon.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    /**
     * Create user with validation
     **/
    @Override
    public User createUser(User user) {
        validateUniqueFields(user);

        return userRepository.save(user);
    }

    /**
     * Update user
     **/
    @Override
    public void updateUser(User user) {
        validateUniqueFields(user);

        User existingUser = userRepository.findById(user.getId())
                .orElseThrow(() -> new UserNotFoundException(user.getId()));

        existingUser.setUsername(user.getUsername());
        existingUser.setName(user.getName());
        existingUser.setLastname(user.getLastname());
        existingUser.setAddress(user.getAddress());
        existingUser.setPhoneNumber(user.getPhoneNumber());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(PasswordEncryption.getHashCode(user.getPassword()));

        userRepository.save(existingUser);
    }

    private void validateUniqueFields(User user) {
        boolean isUsernameExists = userRepository.existsByUsername(user.getUsername());
        if (isUsernameExists) {
            throw new ExistingUserException("Username already exists");
        }

        boolean isEmailExists = userRepository.existsByEmail(user.getEmail());
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


    /**
     * Get all user
     **/
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Get user by ID
     **/
    public User getUserById(Long id) {
        return (userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id)));
    }

    public User getUserByTinNumber(Long tinNumber) {
        return (userRepository.findByTinNumber(tinNumber));
//                .orElseThrow(()->new UserNotFoundException(tinNumber)));
    }

    public User getUserByEmail(String email) {
        return (userRepository.findByEmail(email));
//                .orElseThrow(()->new UserNotFoundException(id)));
    }
}
