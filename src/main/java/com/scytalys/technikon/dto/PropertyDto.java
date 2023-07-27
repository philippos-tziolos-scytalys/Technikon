package com.scytalys.technikon.dto;

import com.scytalys.technikon.domain.PropertyType;
import com.scytalys.technikon.domain.Repair;
import com.scytalys.technikon.domain.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PropertyDto {
    private Long id;

    private Long pinNumber;

    private String address;

    private Integer yearOfConstruction;

    private PropertyType propertyType;

    private String propertyPictureUrl;

    private Long propertyCoordinatesLong;

    private Long propertyCoordinatesLat;

    private boolean activeState;

    private User user;


}
