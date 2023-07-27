package com.scytalys.technikon.dto;


import com.scytalys.technikon.domain.Role;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
    private Long id;
    private Long tinNumber;
    private String name;
    private String lastname;
    private String address;
    private Long phoneNumber;
    private String username;
    private String email;
    private String password;
    private Role role;
}
