package com.scytalys.technikon.dto;

import com.scytalys.technikon.domain.PropertyType;
import com.scytalys.technikon.domain.User;
import jakarta.persistence.Column;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PropertyDto {
    @Column(name = "pin")
    private Long pinNumber;
    private String address;
    private Integer yearOfConstruction;
    private PropertyType propertyType;
    private String propertyPictureUrl;
    private Long propertyCoordinatesLong;
    private Long propertyCoordinatesLat;
    private boolean activeState = true;
    private User owner;
}
