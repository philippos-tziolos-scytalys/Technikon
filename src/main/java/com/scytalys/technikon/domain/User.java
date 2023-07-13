package com.scytalys.technikon.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "\"user\"")
@SequenceGenerator(name = "idGenerator", sequenceName = "user_seq", initialValue = 1, allocationSize = 1)

public class User extends BaseModel {

    @Column(name = "tin_number", length = 20)
    private Long tinNumber;
    @Column(name = "first_name", length = 50)
    private String name;
    @Column(name = "last_name", length = 50)
    private String lastname;
    @Column(name = "address", length = 255)
    private String address;
    @Column(name = "number", length = 12)
    private Long number;
    @Column(name = "user_name", length = 50)
    private String username;
    @Column(name = "email", length = 50)
    private String email;
    @Column(name = "password", length = 255)
    private String password;

    @ManyToMany
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();
}