package com.scytalys.technikon.service;

import com.scytalys.technikon.domain.Repair;

import java.util.Date;
import java.util.List;

public interface RepairService {
    void update(Repair repair, Long repairId);

    Repair create(Repair repair);

    List<Repair> findRepairByDate(Date repairDate);

    void delete(Long repairId);

    void delete(Repair repair);
}
