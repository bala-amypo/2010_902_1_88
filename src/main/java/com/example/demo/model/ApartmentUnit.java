package com.example.demo.model;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Table(name = "apartment_units")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApartmentUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String unitNumber;

    private Integer floor;

    @OneToOne
    private User owner;
}
