package com.scytalys.technikon.service.impl;

import com.scytalys.technikon.domain.Property;
import com.scytalys.technikon.domain.User;
import com.scytalys.technikon.exception.ExistingUserException;
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
        validateUniqueFields(newProperty);
        User user = newProperty.getUser();
        User existingUser = userRepository.findByTinNumber(user.getTinNumber());
        newProperty.setUser(existingUser);
        return propertyRepository.save(newProperty);
    }

    private void validateUniqueFields(Property property) {
        boolean isPinNumberExists = propertyRepository.existsByPinNumber(property.getPinNumber());
        if (isPinNumberExists) {
            throw new ExistingUserException("Property Identification number already exists");
        }

        boolean isAddressExists = propertyRepository.existsByAddress(property.getAddress());
        if (isAddressExists) {
            throw new ExistingUserException("Address already exists");
        }
    }


    public Property getPropertyById(Long id) {
        return propertyRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Id not found" + id));
    }

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
                    return propertyRepository.save(proDB);
                }).orElseThrow(() -> new RuntimeException("Id not found" + id));
    }

    @Override
    public Property searchByPIN(Long pinNumber) {
        return propertyRepository.findByPin(pinNumber);
    }

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


