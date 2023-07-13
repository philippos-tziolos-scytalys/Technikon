package com.scytalys.technikon.dto;


import com.scytalys.technikon.domain.BaseModel;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserDto {
    private Long tinNumber;
    private String name;
    private String lastname;
    private String address;
    private Long number;
    private String username;
    private String email;
    private String password;
}
