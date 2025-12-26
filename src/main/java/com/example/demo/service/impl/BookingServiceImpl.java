package com.example.demo.service.impl;

import com.example.demo.exception.ConflictException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.*;

import java.util.List;

public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepo;
    private final FacilityRepository facilityRepo;
    private final UserRepository userRepo;
    private final BookingLogService logService;

    public BookingServiceImpl(BookingRepository b, FacilityRepository f,
                              UserRepository u, BookingLogService l) {
        this.bookingRepo = b;
        this.facilityRepo = f;
        this.userRepo = u;
        this.logService = l;
    }

    @Override
    public Booking createBooking(Long facilityId, Long userId, Booking booking) {
        Facility f = facilityRepo.findById(facilityId).orElseThrow();
        User u = userRepo.findById(userId).orElseThrow();

        List<Booking> conflicts =
                bookingRepo.findByFacilityAndStartTimeLessThanAndEndTimeGreaterThan(
                        f, booking.getEndTime(), booking.getStartTime());

        if (!conflicts.isEmpty()) {
            throw new ConflictException("conflict detected");
        }

        booking.setFacility(f);
        booking.setUser(u);
        booking.setStatus(Booking.STATUS_CONFIRMED);

        Booking saved = bookingRepo.save(booking);
        logService.addLog(saved.getId(), "Created");

        return saved;
    }

    @Override
    public Booking cancelBooking(Long id) {
        Booking b = bookingRepo.findById(id).orElseThrow();
        b.setStatus(Booking.STATUS_CANCELLED);
        Booking saved = bookingRepo.save(b);
        logService.addLog(saved.getId(), "Cancelled");
        return saved;
    }

    @Override
    public Booking getBooking(Long id) {
        return bookingRepo.findById(id).orElseThrow();
    }
}
