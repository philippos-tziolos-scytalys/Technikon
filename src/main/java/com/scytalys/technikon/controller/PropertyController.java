package com.scytalys.technikon.controller;

import com.scytalys.technikon.domain.Property;
import com.scytalys.technikon.dto.PropertyDto;
import com.scytalys.technikon.mapper.PropertyMapper;
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

    private final PropertyMapper propertyMapper;

    @PostMapping("/create")
    public ResponseEntity<PropertyDto> createProperty(@RequestBody PropertyDto propertyDto) {

        return new ResponseEntity<>(propertyMapper.propertyToPropertyDto(
                propertyService.createProperty(propertyMapper.propertyDtoToProperty(propertyDto))), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Property>> fetchPropertyList() {
        return ResponseEntity.ok(propertyService.fetchPropertyList());
    }

    @PutMapping("/update")
    public void updateProperty(@RequestBody PropertyDto propertyDto) {
        propertyService.updateProperty(propertyMapper.propertyDtoToProperty(propertyDto));
    }

    @GetMapping("/findPropertyByPin")
    public ResponseEntity<Property> findPropertyByPin(@RequestParam("pin") Long pin) {
        return ResponseEntity.ok(propertyService.searchByPIN(pin));
    }

//    @GetMapping("/findPropertyByTin")
//    public ResponseEntity<List<Property>> findPropertyByTin(@RequestParam("tin") Long tin) {
//        return ResponseEntity.ok(propertyService.searchByTIN(tin));
//    }

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

    @GetMapping(headers = "action=findPropertyByUser")
    public ResponseEntity<List<PropertyDto>> findPropertyByUser(Long userId) {
        return ResponseEntity.ok(propertyMapper.propertyListToPropertyDtoList(propertyService.findPropertyByUser(userId)));
    }

}
