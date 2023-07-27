package com.scytalys.technikon.controller;

import com.scytalys.technikon.domain.Property;
import com.scytalys.technikon.domain.User;
import com.scytalys.technikon.dto.PropertyDto;
import com.scytalys.technikon.dto.UserDto;
import com.scytalys.technikon.mapper.PropertyMapper;
import com.scytalys.technikon.service.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/property")
@RequiredArgsConstructor
public class PropertyController {

    private final PropertyService propertyService;

    private final PropertyMapper propertyMapper;

    /** Create property with this controller */
    @PostMapping("/create")
    public ResponseEntity<PropertyDto> createProperty(@RequestBody PropertyDto propertyDto) {

        return new ResponseEntity<>(propertyMapper.propertyToPropertyDto(
                propertyService.createProperty(propertyMapper.propertyDtoToProperty(propertyDto))), HttpStatus.CREATED);
    }



    /** List all properties with this controller */
    @GetMapping("/allproperties")
    public ResponseEntity<List<PropertyDto>> fetchPropertyList() {
        return new  ResponseEntity<>(propertyMapper.propertyListToPropertyDtoList(propertyService.fetchPropertyList()), HttpStatus.ACCEPTED);
    }

    /** Update property controller */
    @PutMapping("/update")
    public void updateProperty(@RequestBody PropertyDto propertyDto) {
        propertyService.updateProperty(propertyMapper.propertyDtoToProperty(propertyDto));
    }

    @PutMapping("/update/{propertyId}")
    public ResponseEntity<PropertyDto> updatePropertyById(@RequestBody PropertyDto propertyDto, @PathVariable("propertyId") Long propertyId) {
        Property updatedProperty = propertyService.updatePropertyById(propertyMapper.propertyDtoToProperty(propertyDto), propertyId);
        PropertyDto updatedpropertyDto = propertyMapper.propertyToPropertyDto(updatedProperty);
        return ResponseEntity.ok(updatedpropertyDto);
    }

    @GetMapping("/search/{propertyId}")
    public ResponseEntity<PropertyDto> findPropertyById(@PathVariable("propertyId") Long propertyId) {
        return new ResponseEntity<>(propertyMapper.propertyToPropertyDto(propertyService.getPropertyById(propertyId)), HttpStatus.ACCEPTED);
    }

    /** Finding and listing properties by their PIN */
    @GetMapping("/findPropertyByPin/{pin}")
    public ResponseEntity<PropertyDto> findPropertyByPin(@RequestParam("pin") Long pin) {
        return new ResponseEntity<>(propertyMapper.propertyToPropertyDto(propertyService.searchByPIN(pin)), HttpStatus.ACCEPTED);
    }

    /** Listing properties by their type */
    @GetMapping("/searchByPropertyType")
    public ResponseEntity<List<Property>> searchByPropertyType(@RequestParam("propertyType") String propertyType) {
        return ResponseEntity.ok(propertyService.searchByPropertyType(propertyType));
    }

    /** Listing properties by their map location (longitude & latitude) */
    @GetMapping("/searchByMapLocationRadius")
    public ResponseEntity<List<Property>> searchByMapLocationRadius(@RequestParam("propertyCoordinatesLong") Long propertyCoordinatesLong, @RequestParam("propertyCoordinatesLat") Long propertyCoordinatesLat) {
        return ResponseEntity.ok(propertyService.searchByMapLocationRadius(propertyCoordinatesLong, propertyCoordinatesLat));
    }

    /** List property by the contruction year */
    @GetMapping("/searchByConstructionYearRange")
    public ResponseEntity<List<Property>> searchByConstructionYearRange(@RequestParam("yearFrom") int yearFrom, @RequestParam("yearTo") int yearTo) {
        return ResponseEntity.ok(propertyService.searchByConstructionYearRange(yearFrom, yearTo));
    }

    /** Deactivate property by their ID */
    @PutMapping("/deactivate/{propertyId}")
    public ResponseEntity<String> deactivateProperty(@PathVariable("propertyId") Long propertyId) {
        propertyService.deactivatePropertyById(propertyId);
        return ResponseEntity.ok("Property set do deactivated");
    }

    /** Delete property by their ID */
    @DeleteMapping("/delete/{propertyId}")
    public ResponseEntity<String> deleteProperty(@PathVariable("propertyId") Long propertyId) {
        propertyService.deletePropertyById(propertyId);
        return ResponseEntity.ok("Property deleted successfully");
    }

    /** List properties by the user ID's */
    @GetMapping(headers = "action=findPropertyByUser")
    public ResponseEntity<List<PropertyDto>> findPropertyByUser(Long userId) {
        return ResponseEntity.ok(propertyMapper.propertyListToPropertyDtoList(propertyService.findPropertyByUser(userId)));
    }

}
