package com.scytalys.technikon.service;

import com.scytalys.technikon.domain.Property;
import com.scytalys.technikon.dto.PropertyDto;

import java.util.List;

public interface PropertyService {
    PropertyDto createProperty(PropertyDto propertyDto);

    List<Property> fetchPropertyList();

    void updateProperty(PropertyDto propertyDto, Long propertyId);

    PropertyDto searchByPIN(Long pin);

    List<PropertyDto> searchByTIN(Long tin);

    List<PropertyDto> searchByPropertyType(String propertyType);

    List<PropertyDto> searchByMapLocationRadius(Long longitude, Long latitude);

    List<PropertyDto> searchByConstructionYearRange(int yearFrom, int yearTo);

    void deactivatePropertyById(Long propertyId);

    void deletePropertyById(Long propertyId);
}
