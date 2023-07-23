package com.scytalys.technikon.controller;

import com.scytalys.technikon.domain.Report;
import com.scytalys.technikon.domain.ReportType;
import com.scytalys.technikon.dto.ReportDto;
import com.scytalys.technikon.dto.UserDto;
import com.scytalys.technikon.mapper.UserMapper;
import com.scytalys.technikon.service.ReportService;
import com.scytalys.technikon.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController{

    private final UserService userService;
    private final ReportService reportService;
    private final UserMapper userMapper;

    @PostMapping("/create")
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto){
        UserDto newUser = userService.createUser(userDto);

        ReportDto newUserReport = new ReportDto(new Date(),ReportType.user_registration,"User registration of tin ".concat(newUser.getTinNumber().toString()),userMapper.userDtoToUser(newUser));
        reportService.reportSubmission(newUserReport);

        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<UserDto> searchUser(@PathVariable("id") Long id){
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.ACCEPTED);
    }
    @GetMapping("/search/tin/{tinNumber}")
    public ResponseEntity<UserDto> searchUserByTin(@PathVariable("tinNumber") Long tinNumber){
        return new ResponseEntity<>(userService.getUserByTinNumber(tinNumber), HttpStatus.ACCEPTED);
    }
    @GetMapping("/search/email/{email}")
    public ResponseEntity<UserDto> searchUserByEmail(@PathVariable("email") String email){
        return new ResponseEntity<>(userService.getUserByEmail(email), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") final Long id) {
        userService.deleteUser(id);

        ReportDto UserDeletionReport = new ReportDto(new Date(),ReportType.user_deletion,"User deletion of id ".concat(id.toString()),userMapper.userDtoToUser(null));
        reportService.reportSubmission(UserDeletionReport);

        return ResponseEntity.ok("User deleted successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long id, @RequestBody UserDto userDto) {
        UserDto updatedUser = userService.updateUser(userDto, id);

        ReportDto UserUpdateReport = new ReportDto(new Date(),ReportType.user_update,"User update of tin ".concat(updatedUser.getTinNumber().toString()),userMapper.userDtoToUser(updatedUser));
        reportService.reportSubmission(UserUpdateReport);

        return ResponseEntity.ok(updatedUser);
    }
}
