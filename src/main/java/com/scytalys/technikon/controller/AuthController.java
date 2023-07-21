package com.scytalys.technikon.controller;

import com.scytalys.technikon.dto.LoginDto;
import com.scytalys.technikon.dto.UserDto;
import com.scytalys.technikon.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    /** Registering user */
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserDto userDto) {
        String response = authService.register(userDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    /** Logging in user (no valid authentication yet. Must fix.) */
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto) {
        boolean isAuthenticated = authService.authenticate(loginDto);

        if (isAuthenticated) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

}
