package com.scytalys.technikon.controller;

import com.scytalys.technikon.dto.RepairDto;
import com.scytalys.technikon.mapper.RepairMapper;
import com.scytalys.technikon.service.RepairService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/repairs")
@RequiredArgsConstructor
public class RepairController {

    private final RepairService repairService;
    private final RepairMapper repairMapper;

    @PutMapping("/update")
    public void updateRepair(@RequestBody RepairDto repairDto) {
        repairService.update(repairMapper.repairDtoToRepair(repairDto));
    }

    @PostMapping("/create")
    public ResponseEntity<RepairDto> createRepair(@RequestBody RepairDto repairDto) {
        return new ResponseEntity<>(repairMapper.repairToRepairDto(repairService.create(repairMapper.repairDtoToRepair(repairDto))), HttpStatus.CREATED);
    }

    @GetMapping("/find-by/user-id")
    public ResponseEntity<List<RepairDto>> findRepairByUserId(@RequestParam("userId") Long userId) {
        return ResponseEntity.ok(repairMapper.repairListToRepairDtoList(repairService.findRepairByUserId(userId)));
    }

    @GetMapping("/find-by/repair-date")
    public ResponseEntity<List<RepairDto>> findByRepairDate(@RequestParam("repairDate")
                                                            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                                            Date repairDate) {
        return ResponseEntity.ok(repairMapper.repairListToRepairDtoList(repairService.findByRepairDate(repairDate)));
    }

    @GetMapping("/find-by/repair-date-range")
    public ResponseEntity<List<RepairDto>> findByRepairDateBetween(
            @RequestParam("fromRepairDate") Date fromRepairDate,
            @RequestParam("toRepairDate") Date toRepairDate) {
        return ResponseEntity.ok(repairMapper.repairListToRepairDtoList(repairService.findByRepairDateBetween(fromRepairDate, toRepairDate)));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteRepair(@PathVariable("id") Long repairId) {
        repairService.delete(repairId);
        return ResponseEntity.ok("Repair deleted successfully");
    }

}
