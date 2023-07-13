package com.scytalys.technikon.transfer.resource;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserResource extends BaseResource{
        private Long tinNumber;
        private String name;
        private String lastname;
        private String address;
        private Long number;
        private String username;
        private String email;
        private String password;
}
