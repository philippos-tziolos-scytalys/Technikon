package com.scytalys.technikon.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "\"user\"")
@SequenceGenerator(name = "idGenerator", sequenceName = "user_seq", initialValue = 1, allocationSize = 1)
public class User extends BaseModel {

    @Column(name = "tin_number")
    private Long tinNumber;
    @Column(name = "first_name", length = 50)
    private String name;
    @Column(name = "last_name", length = 50)
    private String lastname;
    @Column(name = "address", length = 255)
    private String address;
    @Column(name = "number")
    private Long number;
    @Column(name = "user_name", length = 50)
    private String username;
    @Column(name = "email", length = 255)
    private String email;
    @Column(name = "password", length = 255)
    private String password;


}