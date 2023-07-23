package com.scytalys.technikon.controller;

import com.scytalys.technikon.domain.Property;
import com.scytalys.technikon.domain.ReportType;
import com.scytalys.technikon.dto.PropertyDto;
import com.scytalys.technikon.dto.ReportDto;
import com.scytalys.technikon.service.PropertyService;
import com.scytalys.technikon.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Date;

@RestController
@RequestMapping("/property")
@RequiredArgsConstructor
public class PropertyController {

    private final PropertyService propertyService;
    private final ReportService reportService;

    @PostMapping("/create")
    public ResponseEntity<PropertyDto> createProperty(@RequestBody PropertyDto propertyDto) {
        PropertyDto newProperty = propertyService.createProperty(propertyDto);

        ReportDto newPropertyReport = new ReportDto(new Date(),ReportType.property_registration,"Property registration of pin ".concat(newProperty.getPinNumber().toString()),newProperty.getUser());
        reportService.reportSubmission(newPropertyReport);

        return new ResponseEntity<>(newProperty, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Property>> fetchPropertyList() {
        return ResponseEntity.ok(propertyService.fetchPropertyList());
    }

    @PutMapping("/update")
    public ResponseEntity<PropertyDto> updateProperty(@RequestBody PropertyDto propertyDto, @RequestParam("id") Long propertyId) {
        propertyService.updateProperty(propertyDto, propertyId);

        ReportDto PropertyUpdateReport = new ReportDto(new Date(),ReportType.property_update,"Property update of pin ".concat(propertyDto.getPinNumber().toString()),propertyDto.getUser());
        reportService.reportSubmission(PropertyUpdateReport);

        return ResponseEntity.ok(propertyDto);

    }

    @GetMapping("/findPropertyByPin")
    public ResponseEntity<PropertyDto> findPropertyByPin(@RequestParam("pin") Long pin) {
        return ResponseEntity.ok(propertyService.searchByPIN(pin));
    }

    @GetMapping("/findPropertyByTin")
    public ResponseEntity<List<PropertyDto>> findPropertyByTin(@RequestParam("tin") Long tin) {
        return ResponseEntity.ok(propertyService.searchByTIN(tin));
    }

    @GetMapping("/searchByPropertyType")
    public ResponseEntity<List<PropertyDto>> searchByPropertyType(@RequestParam("propertyType") String propertyType) {
        return ResponseEntity.ok(propertyService.searchByPropertyType(propertyType));
    }

    @GetMapping("/searchByMapLocationRadius")
    public ResponseEntity<List<PropertyDto>> searchByMapLocationRadius(@RequestParam("propertyCoordinatesLong") Long propertyCoordinatesLong, @RequestParam("propertyCoordinatesLat") Long propertyCoordinatesLat) {
        return ResponseEntity.ok(propertyService.searchByMapLocationRadius(propertyCoordinatesLong, propertyCoordinatesLat));
    }

    @GetMapping("/searchByConstructionYearRange")
    public ResponseEntity<List<PropertyDto>> searchByConstructionYearRange(@RequestParam("yearFrom") int yearFrom, @RequestParam("yearTo") int yearTo) {
        return ResponseEntity.ok(propertyService.searchByConstructionYearRange(yearFrom, yearTo));
    }

    @PutMapping("/deactivate/{id}")
    public ResponseEntity<String> deactivateProperty(@RequestBody PropertyDto propertyDto,@PathVariable("id") Long propertyId) {
        propertyService.deactivatePropertyById(propertyId);

        ReportDto PropertyDeactivationReport = new ReportDto(new Date(),ReportType.property_deactivation,"Property deactivation of pin ".concat(propertyDto.getPinNumber().toString()),propertyDto.getUser());
        reportService.reportSubmission(PropertyDeactivationReport);

        return ResponseEntity.ok("Property set do deactivated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProperty(@RequestBody PropertyDto propertyDto,@PathVariable("id") Long propertyId) {
        propertyService.deletePropertyById(propertyId);

        ReportDto PropertyDeactivationReport = new ReportDto(new Date(),ReportType.property_deletion,"Property deletion of pin ".concat(propertyDto.getPinNumber().toString()),propertyDto.getUser());
        reportService.reportSubmission(PropertyDeactivationReport);

        return ResponseEntity.ok("Repair deleted successfully");
    }

}
