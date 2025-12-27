package com.example.demo.controller;

import com.example.demo.model.ApartmentUnitModel;
import com.example.demo.service.ApartmentUnitService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/units")
public class ApartmentUnitController {

    private final ApartmentUnitService unitService;

    public ApartmentUnitController(ApartmentUnitService unitService) {
        this.unitService = unitService;
    }

    @PostMapping("/assign/{userId}")
    public ResponseEntity<ApartmentUnitModel> assign(
            @PathVariable Long userId,
            @RequestBody ApartmentUnitModel unit) {
        return ResponseEntity.ok(unitService.assignUnitToUser(userId, unit));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<ApartmentUnitModel> getByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(unitService.getUnitByUser(userId));
    }
}