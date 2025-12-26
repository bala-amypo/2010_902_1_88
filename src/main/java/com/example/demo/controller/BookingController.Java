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
    public ResponseEntity<?> createBooking(@PathVariable Long facilityId,
                                           @PathVariable Long userId,
                                           @RequestBody Booking booking) {
        Booking saved = bookingService.createBooking(facilityId, userId, booking);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/cancel/{bookingId}")
    public ResponseEntity<?> cancelBooking(@PathVariable Long bookingId) {
        Booking cancelled = bookingService.cancelBooking(bookingId);
        return ResponseEntity.ok(cancelled);
    }

    @GetMapping("/{bookingId}")
    public ResponseEntity<?> getBooking(@PathVariable Long bookingId) {
        Booking booking = bookingService.getBookingById(bookingId);
        return ResponseEntity.ok(booking);
    }
}

// package com.example.demo.controller;

// import com.example.demo.model.Booking;
// import com.example.demo.service.BookingService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/bookings")
// public class BookingController {

//     @Autowired
//     private BookingService bookingService;

//     @PostMapping("/{facilityId}/{userId}")
//     public Booking createBooking(@PathVariable Long facilityId, @PathVariable Long userId, @RequestBody Booking booking) {
//         return bookingService.createBooking(facilityId, userId, booking);
//     }

//     @PutMapping("/cancel/{bookingId}")
//     public Booking cancelBooking(@PathVariable Long bookingId) {
//         return bookingService.cancelBooking(bookingId);
//     }

//     @GetMapping("/{bookingId}")
//     public Booking getBooking(@PathVariable Long bookingId) {
//         return bookingService.getBooking(bookingId);
//     }
// }
