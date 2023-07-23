package com.scytalys.technikon.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "\"user\"")
@SequenceGenerator(name = "idGenerator", sequenceName = "user_seq", initialValue = 1, allocationSize = 1)
public class User extends BaseModel {


    @NotEmpty
    @Pattern(regexp = "\\d{9}", message = "TIN number must be exactly 9 digits")
    @Column(name = "tin_number")
    private Long tinNumber;


    @Column(name = "first_name", length = 50)
    private String name;
    @Column(name = "last_name", length = 50)
    private String lastname;
    @Column(name = "address")
    private String address;

    @NotEmpty
    @Pattern(regexp = "\\d{10}", message = "TIN number must be exactly 9 digits")
    @Column(name = "number")
    private Long phoneNumber;

    @NotEmpty
    @Column(name = "user_name", unique = true)
    private String username;

    @Email
    @Column(name = "email", length = 50)
    private String email;

    @NotEmpty
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!]).{8,}$", message = "Invalid password")
    @Column(name = "password" )
    private String password;


    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Property> properties;

    @ManyToMany
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();


}