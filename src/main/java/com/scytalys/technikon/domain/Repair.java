package com.scytalys.technikon.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Repairs")
@SequenceGenerator(name = "idGenerator", sequenceName = "repair_seq", initialValue = 1, allocationSize = 1)
public class Repair extends BaseModel {
    @Enumerated(EnumType.STRING)
    @Column(length = 15, nullable = false)
    private RepairType repairType;

    @Enumerated(EnumType.STRING)
    @Column(length = 11, nullable = false)
    private RepairStatus repairStatus = RepairStatus.PENDING;

    @NotNull
    @Column(length = 1000, nullable = false)
    private String description;

    @Column(nullable = false)
    private Date repairDate;

    @Column(nullable = false)
    private BigDecimal cost;
}
