package com.scytalys.technikon.mapper;

import com.scytalys.technikon.domain.Property;
import com.scytalys.technikon.dto.PropertyDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface PropertyMapper {

    Property propertyDtoToProperty(PropertyDto propertyDto);

    PropertyDto propertyToPropertyDto(Property property);

    List<Property> propertyDtoListToPropertyList(List<PropertyDto> propertyDtoList);

    List<PropertyDto> propertyListToPropertyDtoList(List<Property> propertyList);
}
