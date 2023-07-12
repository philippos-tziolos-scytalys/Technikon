package com.scytalys.technikon.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "\"user\"")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "tin_number", length = 20)
    private Long tinNumber;
    @Column(name = "first_name", length = 255)
    private String name;
    @Column(name = "last_name", length = 255)
    private String lastname;
    @Column(name = "address", length = 255)
    private String address;
    @Column(name = "number", length = 12)
    private Long number;
    @Column(name = "user_name", length = 255)
    private String username;
    @Column(name = "email", length = 255)
    private String email;
    @Column(name = "password", length = 255)
    private String password;

}