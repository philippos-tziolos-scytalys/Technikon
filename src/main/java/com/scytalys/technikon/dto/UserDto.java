package com.scytalys.technikon.dto;


import lombok.Data;

@Data
public class UserDto {
    private Long tinNumber;
    private String name;
    private String lastname;
    private String address;
    private Long phoneNumber;
    private String username;
    private String email;
    private String password;
}
