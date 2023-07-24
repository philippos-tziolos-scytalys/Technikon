package com.scytalys.technikon.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "property")
@SequenceGenerator(name = "idGenerator", sequenceName = "property_seq", initialValue = 1, allocationSize = 1)
public class Property extends BaseModel {


    @NotEmpty
    @Pattern(regexp = "^E9.*$", message = "Invalid Property Identification Number")
    @Column(name = "pin")
    private Long pinNumber;

    @Column(length = 50)
    @Size(max = 50, message = "Address cannot be bigger than 50 characters.")
    private String address;

    @Column(name = "year_of_construction")
    private Integer yearOfConstruction;

    @Enumerated(EnumType.STRING)
    @Column(name = "property_type")
    private PropertyType propertyType;

    @Column(name = "property_picture")
    private String propertyPictureUrl;

    @Column(name = "map_location_long")
    private Long propertyCoordinatesLong;

    @Column(name = "map_location_lat")
    private Long propertyCoordinatesLat;

    @Column(name = "active_state")
    private boolean activeState;

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL)
    private List<Repair> repairs;

    @ManyToOne()
    private User user;
}