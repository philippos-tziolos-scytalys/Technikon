package com.scytalys.technikon.service.impl;

import com.scytalys.technikon.domain.Property;
import com.scytalys.technikon.repository.PropertyRepository;
import com.scytalys.technikon.service.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PropertyServiceImpl implements PropertyService {


    private final PropertyRepository propertyRepository;

    /** Create new property */
    @Override
    public Property createProperty(Property property) {
        return propertyRepository.save(property);
    }

    /** List all properties */
    @Override
    public List<Property> fetchPropertyList() {
        return propertyRepository.findAll();
    }

    /** Update property */
    @Override
    public void updateProperty(Property property) {
        Property proDB = propertyRepository.findById(property.getId()).get();

        proDB.setAddress(property.getAddress());
        proDB.setPinNumber(property.getPinNumber());
        proDB.setAddress(property.getAddress());
        proDB.setYearOfConstruction(property.getYearOfConstruction());
        proDB.setPropertyType(property.getPropertyType());
//        proDB.setUser(property.getUser());
        proDB.setPropertyPictureUrl(property.getPropertyPictureUrl());
        proDB.setPropertyCoordinatesLong(property.getPropertyCoordinatesLong());
        proDB.setPropertyCoordinatesLat(property.getPropertyCoordinatesLat());
        proDB.setActiveState(property.isActiveState());

        propertyRepository.save(proDB);

    }

    /** List property by unique PIN */
    @Override
    public Property searchByPIN(Long pin) {
        return propertyRepository.findByPin(pin);
    }

    /** List property by type */
    @Override
    public List<Property> searchByPropertyType(String propertyType) {
        return propertyRepository.findByPropertyType(propertyType).orElse(null);
    }

    /** List property by the map location radius (longitude & latitude */
    @Override
    public List<Property> searchByMapLocationRadius(Long longitude, Long latitude) {
        return null; //TODO
    }

    /** List by year property constructed */
    @Override
    public List<Property> searchByConstructionYearRange(int yearFrom, int yearTo) {
        return propertyRepository.findByConstructionYearRange(yearFrom, yearTo).orElse(null);
    }

    /** Deactivate property by its ID */
    @Override
    public void deactivatePropertyById(Long propertyId) {
        Property proDB = propertyRepository.findById(propertyId).get();
        proDB.setActiveState(false);

        propertyRepository.save(proDB);
    }

    /** Delete property */
    @Override
    public void deletePropertyById(Long propertyId) {
        propertyRepository.deleteById(propertyId);
    }

    /** List properties by the user (owners) */
    @Override
    public List<Property> findPropertyByUser(Long userId) {
        return propertyRepository.findPropertyByUser(userId).orElse(null);
    }
}