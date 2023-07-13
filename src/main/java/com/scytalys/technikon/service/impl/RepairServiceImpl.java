package com.scytalys.technikon.service.impl;

import com.scytalys.technikon.domain.Repair;
import com.scytalys.technikon.repository.RepairRepository;
import com.scytalys.technikon.service.RepairService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RepairServiceImpl implements RepairService {
    private final RepairRepository repairRepository;


    @Override
    public void update(final Repair repair) {
        Repair existingRepair = repairRepository.findById(repair.getId()).orElseThrow(
                () -> new RuntimeException("Repair with id -> %s not found".formatted(repair.getId()))
        );
        existingRepair.setRepairType(repair.getRepairType());
        existingRepair.setRepairStatus(repair.getRepairStatus());
        existingRepair.setDescription(repair.getDescription());
        existingRepair.setRepairDate(repair.getRepairDate());
        existingRepair.setCost(repair.getCost());
        repairRepository.save(existingRepair);
    }

    @Override
    public Repair create(final Repair repair) {
        return repairRepository.save(repair);
    }

    @Override
    public List<Repair> findByRepairDate(final Date repairDate) {
        return repairRepository.findByRepairDate(repairDate);
    }

    @Override
    public List<Repair> findByRepairDateBetween(Date fromRepairDate, Date toRepairDate) {
        return repairRepository.findByRepairDateBetween(fromRepairDate, toRepairDate);
    }

    @Override
    public void delete(final Repair repair) {
        final Repair existingRepair = repairRepository.getReferenceById(repair.getId());
        repairRepository.delete(existingRepair);
    }

    @Override
    public void delete(final Long repairId) {
        final Repair existingRepair = repairRepository.getReferenceById(repairId);
        repairRepository.delete(existingRepair);
    }

}
