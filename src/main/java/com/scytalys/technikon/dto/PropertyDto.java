package com.scytalys.technikon.dto;

import com.scytalys.technikon.domain.Property_type;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PropertyDto {

    private Long pinNumber;
    private String address;
    private int yearOfConstruction;
    private Property_type propertyType;
    private Long ownerTin;
    private String propertyPictureUrl;
    private Long propertyCoordinatesLong;
    private Long propertyCoordinatesLat;
    private boolean activeState = true;
}
