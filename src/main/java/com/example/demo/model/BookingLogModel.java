package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "booking_logs")
public class BookingLogModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private BookingModel booking;

    private String logMessage;
    private LocalDateTime loggedAt;

    public BookingLogModel() {
    }

    public Long getId() {
        return id;
    }

    public BookingModel getBooking() {
        return booking;
    }

    public String getLogMessage() {
        return logMessage;
    }

    public LocalDateTime getLoggedAt() {
        return loggedAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBooking(BookingModel booking) {
        this.booking = booking;
    }

    public void setLogMessage(String logMessage) {
        this.logMessage = logMessage;
    }

    public void setLoggedAt(LocalDateTime loggedAt) {
        this.loggedAt = loggedAt;
    }
}
