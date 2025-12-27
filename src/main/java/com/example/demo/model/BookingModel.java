package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
public class BookingModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private FacilityModel facility;

    @ManyToOne
    private UserModel user;

    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String status;

    public BookingModel() {
    }

    public Long getId() {
        return id;
    }

    public FacilityModel getFacility() {
        return facility;
    }

    public UserModel getUser() {
        return user;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFacility(FacilityModel facility) {
        this.facility = facility;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}