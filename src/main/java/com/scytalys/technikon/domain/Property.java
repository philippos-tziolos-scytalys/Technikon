package com.scytalys.technikon.domain;

import jakarta.persistence.*;
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

    @Column(name = "pin")
    private Long pinNumber;

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

    @OneToMany(cascade = CascadeType.ALL)
    private List<Repair> repairs;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;
}