package com.scytalys.technikon.mapper;

import com.scytalys.technikon.domain.Repair;
import com.scytalys.technikon.dto.RepairDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface RepairMapper {
    Repair repairDtoToRepair(RepairDto repairDto);

    RepairDto repairToRepairDto(Repair repair);

    List<Repair> repairDtoListToRepairList(List<RepairDto> repairDtoList);

    List<RepairDto> repairListToRepairDtoList(List<Repair> repairList);
}
