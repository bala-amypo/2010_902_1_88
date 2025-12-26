package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "booking_logs")
public class BookingLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Booking booking;

    private String action;
    private String performedBy; // or Long userId depending on your logic

    public BookingLog() {}

    // Constructor to match your usage
    public BookingLog(Booking booking, String action, String performedBy) {
        this.booking = booking;
        this.action = action;
        this.performedBy = performedBy;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Booking getBooking() { return booking; }
    public void setBooking(Booking booking) { this.booking = booking; }

    public String getAction() { return action; }
    public void setAction(String action) { this.action = action; }

    public String getPerformedBy() { return performedBy; }
    public void setPerformedBy(String performedBy) { this.performedBy = performedBy; }
}
