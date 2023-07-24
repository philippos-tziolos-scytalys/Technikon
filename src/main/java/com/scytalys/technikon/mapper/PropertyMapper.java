package com.scytalys.technikon.mapper;

import com.scytalys.technikon.domain.Property;
import com.scytalys.technikon.dto.PropertyDto;
import org.mapstruct.Mapper;
@Mapper
public interface PropertyMapper {
    Property propertyDtoToProperty(PropertyDto propertyDto);

    PropertyDto propertyToPropertyDto(Property property);
}
