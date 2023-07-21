package com.scytalys.technikon.service;

import com.scytalys.technikon.dto.LoginDto;
import com.scytalys.technikon.dto.UserDto;

public interface AuthService {

    String register(UserDto userDto);
    boolean authenticate(LoginDto loginDto);
}
