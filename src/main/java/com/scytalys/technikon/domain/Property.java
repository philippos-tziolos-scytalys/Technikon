package com.scytalys.technikon.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "\"property\"")
public class Property extends BaseModel {

    @Column(name = "address")
    private String address;

    @Column(name = "year_of_construction")
    private int yearOfConstruction;

    @Enumerated(EnumType.STRING)
    @Column(name = "property_type")
    private Property_type propertyType;

    //private Account ownerId;

    @Column(name = "property_picture")
    private String propertyPictureUrl;

    @Column(name = "map_location")
    private String propertyCoordinates;
}
