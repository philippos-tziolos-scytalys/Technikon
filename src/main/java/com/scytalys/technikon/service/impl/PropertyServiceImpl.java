package com.scytalys.technikon.service.impl;

import com.scytalys.technikon.domain.Property;
import com.scytalys.technikon.domain.User;
import com.scytalys.technikon.exception.UserNotFoundException;
import com.scytalys.technikon.repository.PropertyRepository;
import com.scytalys.technikon.repository.UserRepository;
import com.scytalys.technikon.service.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PropertyServiceImpl implements PropertyService {


    private final PropertyRepository propertyRepository;
    private final UserRepository userRepository;

    @Override
    public Property createProperty(Property newProperty) {
        User user = newProperty.getUser();
        User existingUser = userRepository.findById(user.getId())
                .orElseThrow(() -> new UserNotFoundException(user.getId()));
        newProperty.setUser(existingUser);
        return propertyRepository.save(newProperty);
    }

    @Override
    public List<Property> fetchPropertyList() {
        return propertyRepository.findAll();
    }

    @Override
    public void updateProperty(Property property) {
        Property proDB = propertyRepository.findById(property.getId()).orElseThrow(
                () -> new RuntimeException("Id not found" + property.getId())
        );


        proDB.setAddress(property.getAddress());
        proDB.setPinNumber(property.getPinNumber());
        proDB.setAddress(property.getAddress());
        proDB.setYearOfConstruction(property.getYearOfConstruction());
        proDB.setPropertyType(property.getPropertyType());
// proDB.setUser(property.getUser());
        proDB.setPropertyPictureUrl(property.getPropertyPictureUrl());
        proDB.setPropertyCoordinatesLong(property.getPropertyCoordinatesLong());
        proDB.setPropertyCoordinatesLat(property.getPropertyCoordinatesLat());
        proDB.setActiveState(property.isActiveState());

        propertyRepository.save(proDB);

    }


    public Property updatePropertyById(Property property, Long id) {
        return propertyRepository.findById(id)
                .map(proDB -> {
                    proDB.setPinNumber(property.getPinNumber());
                    proDB.setAddress(property.getAddress());
                    proDB.setYearOfConstruction(property.getYearOfConstruction());
                    proDB.setPropertyType(property.getPropertyType());
                    proDB.setPropertyPictureUrl(property.getPropertyPictureUrl());
                    proDB.setPropertyCoordinatesLong(property.getPropertyCoordinatesLong());
                    proDB.setPropertyCoordinatesLat(property.getPropertyCoordinatesLat());
                    proDB.setActiveState(property.isActiveState());
                    // proDB.setUser(property.getUser());
                    return propertyRepository.save(proDB);
                }).orElseThrow(() -> new RuntimeException("Id not found" + id));
    }

    @Override
    public Property searchByPIN(Long pin) {
        return propertyRepository.findByPin(pin);
    }

// @Override
// public List<Property> searchByTIN(Long tin) {
// return propertyRepository.findByTin(tin).orElse(null);
// }

    @Override
    public List<Property> searchByPropertyType(String propertyType) {
        return propertyRepository.findByPropertyType(propertyType).orElse(null);
    }

    @Override
    public List<Property> searchByMapLocationRadius(Long longitude, Long latitude) {
        return null; //TODO
    }


    @Override
    public List<Property> searchByConstructionYearRange(int yearFrom, int yearTo) {
        return propertyRepository.findByConstructionYearRange(yearFrom, yearTo).orElse(null);
    }

    @Override
    public void deactivatePropertyById(Long propertyId) {
        Property proDB = propertyRepository.findById(propertyId).get();
        proDB.setActiveState(false);

        propertyRepository.save(proDB);
    }

    @Override
    public void deletePropertyById(Long propertyId) {
        propertyRepository.deleteById(propertyId);
    }

    @Override
    public List<Property> findPropertyByUser(Long userId) {
        return null;
    }
}


//    public List<Property> fyByUser(Long userId) {
//        return propertyRepository.findPropertyByUser(userId).orElse(null);
//    }

