package com.scytalys.technikon.controller;

import com.scytalys.technikon.domain.Property;
import com.scytalys.technikon.domain.Repair;
import com.scytalys.technikon.dto.PropertyDto;
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



    /** Create repair controller */
    @PostMapping("/create")
    public ResponseEntity<RepairDto> createRepair(@RequestBody RepairDto repairDto) {
        return new ResponseEntity<>(repairMapper.repairToRepairDto(repairService.create(repairMapper.repairDtoToRepair(repairDto))), HttpStatus.CREATED);
    }

    /** List all repairs with this controller */
    @GetMapping("/allrepairs")
    public ResponseEntity<List<RepairDto>> fetchPropertyList() {
        return new  ResponseEntity<>(repairMapper.repairListToRepairDtoList(repairService.fetchRepairList()), HttpStatus.ACCEPTED);
    }

    /** Delete repair by the ID */
    @DeleteMapping("/delete/{repairId}")
    public ResponseEntity<String> deleteRepair(@PathVariable("repairId") Long repairId) {
        repairService.deleteRepairById(repairId);
        return ResponseEntity.ok("Repair deleted successfully");
    }

    /** Update repair by the ID */
    @PutMapping("/update/{repairId}")
    public ResponseEntity<RepairDto> updateRepairById(@RequestBody RepairDto repairDto, @PathVariable("repairId") Long repairId) {
        Repair updatedRepair = repairService.updateRepairById(repairMapper.repairDtoToRepair(repairDto), repairId);
        RepairDto updatedRepairDto = repairMapper.repairToRepairDto(updatedRepair);
        return ResponseEntity.ok(updatedRepairDto);
    }

    /** Find repair by id **/
    @GetMapping("/search/{repairId}")
    public ResponseEntity<RepairDto> findRepairById(@PathVariable("repairId") Long repairId) {
        return new ResponseEntity<>(repairMapper.repairToRepairDto(repairService.getRepairById(repairId)), HttpStatus.ACCEPTED);
    }


    /** Update repair controller */
    @PutMapping("/update")
    public void updateRepair(@RequestBody RepairDto repairDto) {
        repairService.update(repairMapper.repairDtoToRepair(repairDto));
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



}
