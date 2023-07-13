package com.scytalys.technikon.mapper;

import com.scytalys.technikon.domain.Repair;
import com.scytalys.technikon.dto.RepairDto;
import org.mapstruct.Mapper;

@Mapper
public interface RepairMapper {
    Repair repairDtoToRepair(RepairDto repairDto);

    RepairDto repairToRepairDto(Repair repair);
}
