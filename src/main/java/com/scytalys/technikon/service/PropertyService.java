package com.scytalys.technikon.service;

import com.scytalys.technikon.domain.Property;

import java.util.List;

public interface PropertyService {
    Property createProperty(Property property);

    List<Property> fetchPropertyList();

    void updateProperty(Property property);

    Property searchByPIN(Long pin);

    List<Property> searchByPropertyType(String propertyType);

    List<Property> searchByMapLocationRadius(Long longitude, Long latitude);

    List<Property> searchByConstructionYearRange(int yearFrom, int yearTo);

    void deactivatePropertyById(Long propertyId);

    void deletePropertyById(Long propertyId);

    List<Property> findPropertyByUser(Long userId);
}
