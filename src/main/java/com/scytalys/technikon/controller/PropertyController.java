package com.scytalys.technikon.controller;

import com.scytalys.technikon.domain.Property;
import com.scytalys.technikon.service.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/property")
@RequiredArgsConstructor
public class PropertyController {

    private final PropertyService propertyService;

    @PostMapping("/create")
    public ResponseEntity<Property> createProperty(@RequestBody Property property) {
        Property newProperty = propertyService.createProperty(property);
        return new ResponseEntity<>(newProperty, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Property>> fetchPropertyList() {
        return ResponseEntity.ok(propertyService.fetchPropertyList());
    }

    @PutMapping("/update")
    public void updateProperty(@RequestBody Property property, @RequestParam("id") Long propertyId) {
        propertyService.updateProperty(property, propertyId);
    }

    @GetMapping("/findPropertyByPin")
    public ResponseEntity<Property> findPropertyByPin(@RequestParam("pin") Long pin) {
        return ResponseEntity.ok(propertyService.searchByPIN(pin));
    }

    @GetMapping("/findPropertyByTin")
    public ResponseEntity<List<Property>> findPropertyByTin(@RequestParam("tin") Long tin) {
        return ResponseEntity.ok(propertyService.searchByTIN(tin));
    }

    @GetMapping("/searchByPropertyType")
    public ResponseEntity<List<Property>> searchByPropertyType(@RequestParam("propertyType") String propertyType) {
        return ResponseEntity.ok(propertyService.searchByPropertyType(propertyType));
    }

    @GetMapping("/searchByMapLocationRadius")
    public ResponseEntity<List<Property>> searchByMapLocationRadius(@RequestParam("propertyCoordinatesLong") Long propertyCoordinatesLong, @RequestParam("propertyCoordinatesLat") Long propertyCoordinatesLat) {
        return ResponseEntity.ok(propertyService.searchByMapLocationRadius(propertyCoordinatesLong, propertyCoordinatesLat));
    }

    @GetMapping("/searchByConstructionYearRange")
    public ResponseEntity<List<Property>> searchByConstructionYearRange(@RequestParam("yearFrom") int yearFrom, @RequestParam("yearTo") int yearTo) {
        return ResponseEntity.ok(propertyService.searchByConstructionYearRange(yearFrom, yearTo));
    }

    @PutMapping("/deactivate/{id}")
    public ResponseEntity<String> deactivateProperty(@PathVariable("id") Long propertyId) {
        propertyService.deactivatePropertyById(propertyId);
        return ResponseEntity.ok("Property set do deactivated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProperty(@PathVariable("id") Long propertyId) {
        propertyService.deletePropertyById(propertyId);
        return ResponseEntity.ok("Repair deleted successfully");
    }

}
