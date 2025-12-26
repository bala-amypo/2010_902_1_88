package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.BookingLogService;

import java.util.List;

public class BookingLogServiceImpl implements BookingLogService {

    private final BookingLogRepository logRepo;
    private final BookingRepository bookingRepo;

    public BookingLogServiceImpl(BookingLogRepository l, BookingRepository b) {
        this.logRepo = l;
        this.bookingRepo = b;
    }

    @Override
    public BookingLog addLog(Long bookingId, String msg) {
        Booking b = bookingRepo.findById(bookingId).orElseThrow();
        BookingLog log = new BookingLog(null, b, msg, null);
        return logRepo.save(log);
    }

    @Override
    public List<BookingLog> getLogsByBooking(Long bookingId) {
        Booking b = bookingRepo.findById(bookingId).orElseThrow();
        return logRepo.findByBookingOrderByLoggedAtAsc(b);
    }
}
