package com.example.demo.repository;

import com.example.demo.entity.ApartmentUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApartmentUnitRepository extends JpaRepository<ApartmentUnit, Long> {
    List<ApartmentUnit> findByBuilding(String building);
    List<ApartmentUnit> findByFloor(Integer floor);
}