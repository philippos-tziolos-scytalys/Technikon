package com.scytalys.technikon.controller;

import com.scytalys.technikon.base.BaseComponent;
import com.scytalys.technikon.domain.BaseModel;
import com.scytalys.technikon.domain.User;
import com.scytalys.technikon.dto.UserDto;
import com.scytalys.technikon.mapper.BaseMapper;
import com.scytalys.technikon.mapper.UserMapper;
import com.scytalys.technikon.repository.UserRepository;
import com.scytalys.technikon.service.BaseService;
import com.scytalys.technikon.service.UserService;
import com.scytalys.technikon.transfer.resource.BaseResource;
import com.scytalys.technikon.transfer.resource.UserResource;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController extends BaseController<User, UserResource> {

    private final UserService userService;
    private final UserMapper userMapper;

    @Override
    protected BaseService<User, Long> getBaseService() {
        return userService;
    }

    @Override
    public BaseMapper<User, UserResource> getMapper() {
        return userMapper;
    }

    @PostMapping("/create")
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto){
        UserDto newUser = userService.createUser(userDto);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<UserDto> searchUser(@PathVariable("id") Long id){
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") final Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("Repair deleted successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long id, @RequestBody UserDto userDto) {
        UserDto updatedUser = userService.updateUser(userDto, id);
        return ResponseEntity.ok(updatedUser);
    }
}
