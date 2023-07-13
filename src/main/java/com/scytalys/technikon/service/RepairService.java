package com.scytalys.technikon.service;

import com.scytalys.technikon.domain.Repair;

import java.util.Date;
import java.util.List;

public interface RepairService {
    void update(Repair repair);

    Repair create(Repair repair);

    List<Repair> findByRepairDate(Date repairDate);

    List<Repair> findByRepairDateBetween(Date fromRepairDate, Date toRepairDate);

    void delete(Long repairId);

    void delete(Repair repair);
}
