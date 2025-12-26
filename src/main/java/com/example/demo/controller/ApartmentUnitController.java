package com.example.demo.controller;

import com.example.demo.model.ApartmentUnit;
import com.example.demo.service.ApartmentUnitService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/units")
public class ApartmentUnitController {

    private final ApartmentUnitService apartmentUnitService;

    public ApartmentUnitController(ApartmentUnitService apartmentUnitService) {
        this.apartmentUnitService = apartmentUnitService;
    }

    @PostMapping("/assign/{userId}")
    public ResponseEntity<?> assignUnit(@PathVariable Long userId,
                                        @RequestBody ApartmentUnit unit) {
        ApartmentUnit saved =
                apartmentUnitService.assignUnitToUser(userId, unit);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getUnitByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(
                apartmentUnitService.getUnitByUserId(userId)
        );
    }
}

// package com.example.demo.controller;

// import com.example.demo.model.ApartmentUnit;
// import com.example.demo.service.ApartmentUnitService;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/units")
// public class ApartmentUnitController {

//     private final ApartmentUnitService apartmentUnitService;

//     public ApartmentUnitController(ApartmentUnitService apartmentUnitService) {
//         this.apartmentUnitService = apartmentUnitService;
//     }

//     @PostMapping
//     public ResponseEntity<ApartmentUnit> addUnit(@RequestBody ApartmentUnit unit) {
//         return ResponseEntity.ok(apartmentUnitService.addUnit(unit));
//     }

//     @PutMapping("/{id}")
//     public ResponseEntity<ApartmentUnit> updateUnit(@PathVariable Long id, @RequestBody ApartmentUnit unit) {
//         return ResponseEntity.ok(apartmentUnitService.updateUnit(id, unit));
//     }

//     @GetMapping("/{id}")
//     public ResponseEntity<ApartmentUnit> getUnit(@PathVariable Long id) {
//         return ResponseEntity.ok(apartmentUnitService.getUnitById(id));
//     }

//     @GetMapping
//     public ResponseEntity<List<ApartmentUnit>> getAllUnits() {
//         return ResponseEntity.ok(apartmentUnitService.getAllUnits());
//     }

//     @GetMapping("/user/{userId}")
//     public ResponseEntity<List<ApartmentUnit>> getUnitsByUser(@PathVariable Long userId) {
//         return ResponseEntity.ok(apartmentUnitService.getUnitByUser(userId));
//     }

//     @DeleteMapping("/{id}")
//     public ResponseEntity<Void> deleteUnit(@PathVariable Long id) {
//         apartmentUnitService.deleteUnit(id);
//         return ResponseEntity.ok().build();
//     }
// }


