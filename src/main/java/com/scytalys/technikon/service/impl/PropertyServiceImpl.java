package com.scytalys.technikon.service.impl;

import com.scytalys.technikon.domain.Property;
import com.scytalys.technikon.dto.PropertyDto;
import com.scytalys.technikon.mapper.PropertyMapper;
import com.scytalys.technikon.repository.PropertyRepository;
import com.scytalys.technikon.service.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PropertyServiceImpl extends BaseServiceImpl<Property>  implements PropertyService {

    @Override
    public JpaRepository<Property, Long> getRepository() {
        return propertyRepository;
    }

    private final PropertyRepository propertyRepository;
    private final PropertyMapper propertyMapper;

    @Override
    public PropertyDto createProperty(PropertyDto propertyDto) {

        Property property = propertyMapper.propertyDtoToProperty(propertyDto);
        Property savedProperty = propertyRepository.save(property);

        return propertyMapper.propertyToPropertyDto(savedProperty);
    }

    @Override
    public List<Property> fetchPropertyList() {
        return propertyRepository.findAll();
    }

    @Override
    public void updateProperty(PropertyDto propertyDto, Long propertyId) {

        Property proDB = propertyRepository.findById(propertyId).get();

        proDB.setAddress(propertyDto.getAddress());
        proDB.setPinNumber(propertyDto.getPinNumber());
        proDB.setAddress(propertyDto.getAddress());
        proDB.setYearOfConstruction(propertyDto.getYearOfConstruction());
        proDB.setPropertyType(propertyDto.getPropertyType());
        proDB.setUser(propertyDto.getUser());
        proDB.setPropertyPictureUrl(propertyDto.getPropertyPictureUrl());
        proDB.setPropertyCoordinatesLong(propertyDto.getPropertyCoordinatesLong());
        proDB.setPropertyCoordinatesLat(propertyDto.getPropertyCoordinatesLat());
        proDB.setActiveState(propertyDto.isActiveState());

        propertyMapper.propertyToPropertyDto(proDB);

    }

    @Override
    public PropertyDto searchByPIN(Long pin) {
        return propertyRepository.findByPin(pin);
    }

    @Override
    public List<PropertyDto> searchByTIN(Long tin) {
        return propertyRepository.findByTin(tin).orElse(null);
    }

    @Override
    public List<PropertyDto> searchByPropertyType(String propertyType) {
        return propertyRepository.findByPropertyType(propertyType).orElse(null);
    }

    @Override
    public List<PropertyDto> searchByMapLocationRadius(Long longitude, Long latitude) {
        return null; //TODO
    }


    @Override
    public List<PropertyDto> searchByConstructionYearRange(int yearFrom, int yearTo) {
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
}