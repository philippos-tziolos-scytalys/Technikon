package com.scytalys.technikon.controller;

import com.scytalys.technikon.dto.UserDto;
import com.scytalys.technikon.mapper.UserMapper;
import com.scytalys.technikon.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping("/create")
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto) {

        return new ResponseEntity<>(userMapper.userToUserDto(
                userService.createUser(userMapper.userDtoToUser(userDto))), HttpStatus.CREATED);
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<UserDto> searchUser(@PathVariable("id") Long id) {
        return new ResponseEntity<>(userMapper.userToUserDto(userService.getUserById(id)), HttpStatus.ACCEPTED);
    }

    @GetMapping("/search/tin/{tinNumber}")
    public ResponseEntity<UserDto> searchUserByTin(@PathVariable("tinNumber") Long tinNumber) {
        return new ResponseEntity<>(userMapper.userToUserDto(userService.getUserByTinNumber(tinNumber)), HttpStatus.ACCEPTED);
    }

    @GetMapping("/search/email/{email}")
    public ResponseEntity<UserDto> searchUserByEmail(@PathVariable("email") String email) {
        return new ResponseEntity<>(userMapper.userToUserDto(userService.getUserByEmail(email)), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") final Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully");
    }

    @PutMapping("/update")
    public void updateUser(@RequestBody UserDto userDto) {
        userService.updateUser(userMapper.userDtoToUser(userDto));
    }
}
