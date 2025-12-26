package com.example.demo.model;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;

    private String role = "RESIDENT";

    @OneToOne(mappedBy = "owner")
    private ApartmentUnit apartmentUnit;
}
