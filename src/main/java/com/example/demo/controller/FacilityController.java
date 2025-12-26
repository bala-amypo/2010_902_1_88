package com.example.demo.controller;

import com.example.demo.model.Facility;
import com.example.demo.service.FacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facilities")
public class FacilityController {

    private final FacilityService facilityService;

    @Autowired
    public FacilityController(FacilityService facilityService) {
        this.facilityService = facilityService;
    }

    // Create a new facility
    @PostMapping
    public ResponseEntity<Facility> createFacility(@RequestBody Facility facility) {
        Facility createdFacility = facilityService.createFacility(facility);
        return ResponseEntity.ok(createdFacility);
    }

    // Get all facilities
    @GetMapping
    public ResponseEntity<List<Facility>> getAllFacilities() {
        List<Facility> facilities = facilityService.getAllFacilities();
        return ResponseEntity.ok(facilities);
    }

    // Get facility by ID
    @GetMapping("/{id}")
    public ResponseEntity<Facility> getFacilityById(@PathVariable Long id) {
        Facility facility = facilityService.getFacilityById(id);
        return ResponseEntity.ok(facility);
    }

    // Update a facility
    @PutMapping("/{id}")
    public ResponseEntity<Facility> updateFacility(@PathVariable Long id, @RequestBody Facility facility) {
        Facility updatedFacility = facilityService.updateFacility(id, facility);
        return ResponseEntity.ok(updatedFacility);
    }

    // Delete a facility
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFacility(@PathVariable Long id) {
        facilityService.deleteFacility(id);
        return ResponseEntity.noContent().build();
    }
}
