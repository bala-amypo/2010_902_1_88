package com.example.demo.controller;

import com.example.demo.model.BookingLog;
import com.example.demo.service.BookingLogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/logs")
public class BookingLogController {

    private final BookingLogService bookingLogService;

    public BookingLogController(BookingLogService bookingLogService) {
        this.bookingLogService = bookingLogService;
    }

    @GetMapping("/booking/{bookingId}")
    public ResponseEntity<?> getLogs(@PathVariable Long bookingId) {
        List<BookingLog> logs = bookingLogService.getLogsByBooking(bookingId);
        return ResponseEntity.ok(logs);
    }
}

// package com.example.demo.controller;

// import com.example.demo.model.BookingLog;
// import com.example.demo.service.BookingLogService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/logs")
// public class BookingLogController {

//     @Autowired
//     private BookingLogService bookingLogService;

//     @GetMapping("/booking/{bookingId}")
//     public List<BookingLog> getLogs(@PathVariable Long bookingId) {
//         return bookingLogService.getLogsByBooking(bookingId);
//     }
// }
