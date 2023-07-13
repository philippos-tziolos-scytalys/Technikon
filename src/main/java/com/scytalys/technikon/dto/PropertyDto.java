package com.scytalys.technikon.dto;

import com.scytalys.technikon.domain.PropertyType;
import lombok.Data;

@Data
public class PropertyDto {
    private Long pinNumber;

    private String address;

    private Integer yearOfConstruction;

    private PropertyType propertyType;

    private String propertyPictureUrl;

    private Long propertyCoordinatesLong;

    private Long propertyCoordinatesLat;

    private boolean activeState = true;
}
