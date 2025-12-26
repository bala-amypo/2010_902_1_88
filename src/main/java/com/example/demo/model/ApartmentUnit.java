package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "apartment_units")
public class ApartmentUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "unit_number")
    private String unitNumber;

    @Column(name = "status")
    private String status;

    @Column(name = "type")
    private String type;

    @Column(name = "floor")
    private int floor;

    @Column(name = "user_id")
    private Long userId;

    // Constructors
    public ApartmentUnit() {}

    public ApartmentUnit(String unitNumber, String status, String type, int floor, Long userId) {
        this.unitNumber = unitNumber;
        this.status = status;
        this.type = type;
        this.floor = floor;
        this.userId = userId;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUnitNumber() { return unitNumber; }
    public void setUnitNumber(String unitNumber) { this.unitNumber = unitNumber; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public int getFloor() { return floor; }
    public void setFloor(int floor) { this.floor = floor; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
}
