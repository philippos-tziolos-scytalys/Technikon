package com.scytalys.technikon.controller;

import com.scytalys.technikon.domain.User;
import com.scytalys.technikon.dto.UserDto;
import com.scytalys.technikon.mapper.UserMapper;
import com.scytalys.technikon.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    /** List all users */
    @GetMapping("/allusers")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return new ResponseEntity<>(userMapper.userListToUserDtoList(userService.getAllUsers()), HttpStatus.ACCEPTED);
    }

    /** Create new user */
    @PostMapping("/create")
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto) {

        return new ResponseEntity<>(userMapper.userToUserDto(
                userService.createUser(userMapper.userDtoToUser(userDto))), HttpStatus.CREATED);
    }

    /** Search/Get user by ID */
    @GetMapping("/search/{userID}")
    public ResponseEntity<UserDto> searchUser(@PathVariable("userID") Long userID) {
        return new ResponseEntity<>(userMapper.userToUserDto(userService.getUserById(userID)), HttpStatus.ACCEPTED);
    }


    /** Search/Get user by Tin Number */
    @GetMapping("/search/tin/{tinNumber}")
    public ResponseEntity<UserDto> searchUserByTin(@PathVariable("tinNumber") Long tinNumber) {
        return new ResponseEntity<>(userMapper.userToUserDto(userService.getUserByTinNumber(tinNumber)), HttpStatus.ACCEPTED);
    }

    /** Search/Get user by email */
    @GetMapping("/search/email/{email}")
    public ResponseEntity<UserDto> searchUserByEmail(@PathVariable("email") String email) {
        return new ResponseEntity<>(userMapper.userToUserDto(userService.getUserByEmail(email)), HttpStatus.ACCEPTED);
    }

    /** Search/Get user by username */
    @GetMapping("/search/email/{username}")
    public ResponseEntity<UserDto> searchUserByUsername(@PathVariable("username") String username) {
        return new ResponseEntity<>(userMapper.userToUserDto(userService.getUserByUsername(username)), HttpStatus.ACCEPTED);
    }

    /** Delete user by their ID */
    @DeleteMapping("delete/{userID}")
    public ResponseEntity<String> deleteUser(@PathVariable("userID") final Long userID) {
        userService.deleteUser(userID);
        return ResponseEntity.ok("User deleted successfully");
    }

    /** Update user's credentials (more in UserServiceImpl) */
    @PutMapping("/update")
    public void updateUser(@RequestBody UserDto userDto) {
        userService.updateUser(userMapper.userDtoToUser(userDto));
    }

    @PutMapping("/update/{userID}")
    public ResponseEntity<UserDto> updateUserById(@RequestBody UserDto userDto, @PathVariable("userID") Long userID) {
        User updatedUser = userService.updateUserById(userMapper.userDtoToUser(userDto), userID);
        UserDto updatedUserDto = userMapper.userToUserDto(updatedUser);
        return ResponseEntity.ok(updatedUserDto);
    }

}