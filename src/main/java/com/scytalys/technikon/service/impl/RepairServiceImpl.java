package com.scytalys.technikon.service.impl;

import com.scytalys.technikon.domain.Property;
import com.scytalys.technikon.domain.Repair;
import com.scytalys.technikon.repository.PropertyRepository;
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
    private final PropertyRepository propertyRepository;

    /** Create new repair */
    @Override
    public Repair create(final Repair repair) {
        Property property = repair.getProperty();
        Property existingProperty = propertyRepository.findByPinNumber(property.getPinNumber());
        repair.setProperty(existingProperty);
        return repairRepository.save(repair);
    }


    /** Find all repairs **/
    @Override
    public List<Repair> fetchRepairList() {
        return repairRepository.findAll();
    }



    /** Update repair */
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
        existingRepair.setProperty(repair.getProperty());
        repairRepository.save(existingRepair);
    }

    /**Find repair by id **/
    @Override
    public Repair getRepairById(Long repairId) {
        return repairRepository.findById(repairId).orElseThrow(
                () -> new RuntimeException("Id not found" + repairId));
    }

    /** List all repairs by the user ID */
    @Override
    public List<Repair> findRepairByUserId(Long userId) {
        return repairRepository.findRepairByUserId(userId);
    }

    /** List repairs by their repair date */
    @Override
    public List<Repair> findByRepairDate(final Date repairDate) {
        return repairRepository.findByRepairDate(repairDate);
    }

    /** List repairs between dates given */
    @Override
    public List<Repair> findByRepairDateBetween(Date fromRepairDate, Date toRepairDate) {
        return repairRepository.findByRepairDateBetween(fromRepairDate, toRepairDate);
    }

    @Override
    public Repair updateRepairById(Repair repair, Long repairId) {
        return repairRepository.findById(repairId)
        .map(existingRepair -> {
            existingRepair.setRepairType(repair.getRepairType());
            existingRepair.setRepairStatus(repair.getRepairStatus());
            existingRepair.setDescription(repair.getDescription());
            existingRepair.setRepairDate(repair.getRepairDate());
            existingRepair.setCost(repair.getCost());
//            existingRepair.setProperty(repair.getProperty());
            return repairRepository.save(existingRepair);
        }).orElseThrow(() -> new RuntimeException("Id not found" + repairId));
    }


    @Override
    public void deleteRepairById(Long repairId) {
        repairRepository.deleteById(repairId);
    }

    /** Delete repair with the specific ID */
    @Override
    public void delete(final Long repairId) {
        final Repair existingRepair = repairRepository.getReferenceById(repairId);
        repairRepository.delete(existingRepair);
    }

}
