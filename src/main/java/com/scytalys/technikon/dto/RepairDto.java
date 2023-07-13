package com.scytalys.technikon.dto;

import com.scytalys.technikon.domain.Property;
import com.scytalys.technikon.domain.RepairStatus;
import com.scytalys.technikon.domain.RepairType;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class RepairDto {
    private RepairType repairType;
    private RepairStatus repairStatus;
    private String description;
    private Date repairDate;
    private BigDecimal cost;
    private Property property;
}
