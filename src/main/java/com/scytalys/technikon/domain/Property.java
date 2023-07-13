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
    private boolean activeState = true;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
