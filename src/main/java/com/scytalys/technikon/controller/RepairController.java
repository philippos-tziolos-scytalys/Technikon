package com.scytalys.technikon.controller;

import com.scytalys.technikon.domain.Repair;
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

    @PostMapping("/create")
    public ResponseEntity<Repair> createRepair(@RequestBody Repair repair) {
        Repair newRepair = repairService.create(repair);
        return new ResponseEntity<>(newRepair, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Repair>> findRepairByDate(@RequestParam("repairDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date repairDate) {
        return ResponseEntity.ok(repairService.findRepairByDate(repairDate));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteRepair(@PathVariable("id") Long repairId) {
        repairService.delete(repairId);
        return ResponseEntity.ok("Repair deleted successfully");
    }

}
