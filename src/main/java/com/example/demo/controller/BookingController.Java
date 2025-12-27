package com.example.demo.controller;

import com.example.demo.model.Booking;
import com.example.demo.service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/{facilityId}/{userId}")
    public ResponseEntity<Booking> createBooking(
            @PathVariable Long facilityId,
            @PathVariable Long userId,
            @RequestBody Booking booking) {
        return ResponseEntity.ok(
                bookingService.createBooking(facilityId, userId, booking)
        );
    }

    @PutMapping("/cancel/{bookingId}")
    public ResponseEntity<Booking> cancelBooking(
            @PathVariable Long bookingId) {
        return ResponseEntity.ok(
                bookingService.cancelBooking(bookingId)
        );
    }

    @GetMapping("/{bookingId}")
    public ResponseEntity<Booking> getBooking(
            @PathVariable Long bookingId) {
        return ResponseEntity.ok(
                bookingService.getBooking(bookingId)
        );
    }
}
