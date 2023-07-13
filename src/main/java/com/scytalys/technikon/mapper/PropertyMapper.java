package com.scytalys.technikon.mapper;

import com.scytalys.technikon.domain.Property;
import com.scytalys.technikon.dto.PropertyDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface PropertyMapper {

    Property repairDtoToRepair(PropertyDto propertyDto);

    PropertyDto repairToRepairDto(Property property);

    List<Property> repairDtoListToRepairList(List<PropertyDto> propertyDtoList);

    List<PropertyDto> repairListToRepairDtoList(List<Property> propertyList);
}
