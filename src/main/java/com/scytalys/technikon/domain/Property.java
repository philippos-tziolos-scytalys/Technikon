package com.scytalys.technikon.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "\"property\"")
@SequenceGenerator(name = "idGenerator", sequenceName = "property_seq", initialValue = 1, allocationSize = 1)
public class Property extends BaseModel {

    @Column(name = "pin")
    private Long pinNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "year_of_construction")
    private int yearOfConstruction;

    @Enumerated(EnumType.STRING)
    @Column(name = "property_type")
    private PropertyType propertyType;

    //private Account ownerId;

    @Column(name = "property_picture")
    private String propertyPictureUrl;

    @Column(name = "map_location")
    private String propertyCoordinates;
}
