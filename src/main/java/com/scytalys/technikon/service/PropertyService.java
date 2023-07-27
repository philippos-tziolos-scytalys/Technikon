package com.scytalys.technikon.service;

import com.scytalys.technikon.domain.Property;

import java.util.List;
import java.util.Optional;

public interface PropertyService {
//    Property saveProperty(Property property);

    void updateProperty(Property property);

    Property updatePropertyById(Property property, Long id);

    Property searchByPIN(Long pin);

// List<Property> searchByTIN(Long tin);

    List<Property> searchByPropertyType(String propertyType);

    List<Property> searchByMapLocationRadius(Long longitude, Long latitude);

    List<Property> searchByConstructionYearRange(int yearFrom, int yearTo);

    void deactivatePropertyById(Long propertyId);

    void deletePropertyById(Long propertyId);

    List<Property> findPropertyByUser(Long userId);

    Property createProperty(Property property);


    Property getPropertyById(Long id);

    List<Property> fetchPropertyList();
}