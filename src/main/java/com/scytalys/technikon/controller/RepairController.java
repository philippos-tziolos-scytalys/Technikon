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

@CrossOrigin("*")
@RestController
@RequestMapping("/api/repairs")
@RequiredArgsConstructor
public class RepairController {

    private final RepairService repairService;
    private final RepairMapper repairMapper;

    /** Update repair controller */
    @PutMapping("/update")
    public void updateRepair(@RequestBody RepairDto repairDto) {
        repairService.update(repairMapper.repairDtoToRepair(repairDto));
    }

    /** Create repair controller */
    @PostMapping("/create")
    public ResponseEntity<RepairDto> createRepair(@RequestBody RepairDto repairDto) {
        return new ResponseEntity<>(repairMapper.repairToRepairDto(repairService.create(repairMapper.repairDtoToRepair(repairDto))), HttpStatus.CREATED);
    }

    /** Find repairs by the user's ID */
    @GetMapping("/user/{id}/repairs")
    public ResponseEntity<List<RepairDto>> findRepairByUserId(@PathVariable("id") Long Id) {
        return ResponseEntity.ok(repairMapper.repairListToRepairDtoList(repairService.findRepairByUserId(Id)));
    }

    /** List repairs by their repair dates */
    @GetMapping("/repairs/{repairDate}")
    public ResponseEntity<List<RepairDto>> findByRepairDate(@PathVariable("repairDate")
                                                            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                                            Date repairDate) {
        return ResponseEntity.ok(repairMapper.repairListToRepairDtoList(repairService.findByRepairDate(repairDate)));
    }

    /** List repairs between their repair date */
    @GetMapping("/repairs")
    public ResponseEntity<List<RepairDto>> findByRepairDateBetween(
            @RequestParam("fromRepairDate") Date fromRepairDate,
            @RequestParam("toRepairDate") Date toRepairDate) {
        return ResponseEntity.ok(repairMapper.repairListToRepairDtoList(repairService.findByRepairDateBetween(fromRepairDate, toRepairDate)));
    }

    /** Delete repair by the ID */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteRepair(@PathVariable("id") Long repairId) {
        repairService.delete(repairId);
        return ResponseEntity.ok("Repair deleted successfully");
    }

}
