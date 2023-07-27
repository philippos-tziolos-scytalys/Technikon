package com.scytalys.technikon.service;

import com.scytalys.technikon.domain.Property;
import com.scytalys.technikon.domain.Repair;

import java.util.Date;
import java.util.List;

public interface RepairService {

    Repair create(Repair repair);

    List<Repair> fetchRepairList();

    void deleteRepairById(Long repairId);

    void update(Repair repair);

    Repair getRepairById(Long repairId);

    List<Repair> findRepairByUserId(Long userId);

    List<Repair> findByRepairDate(Date repairDate);

    List<Repair> findByRepairDateBetween(Date fromRepairDate, Date toRepairDate);


    Repair updateRepairById(Repair repair, Long repairId);

    void delete(Long repairId);


}


