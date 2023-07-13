package com.scytalys.technikon.service;

import com.scytalys.technikon.domain.Property;

import java.util.Date;
import java.util.List;

public interface PropertyService {
    Property saveProperty(Property property);

    List<Property> fetchPropertyList();

    Property updateProperty(Property property, Long propertyId);

    Property searchByPIN(Long pin);

    List<Property> searchByTIN(Long tin);

    List<Property> searchByPropertyType(String propertyType);

    List<Property> searchByMapLocationRadius(String coordinates);

    List<Property> searchByConstructionDateRange(Date dateFrom, Date dateTo);

    void deactivatePropertyById(Long propertyId);

    void deletePropertyById(Long propertyId);
}
