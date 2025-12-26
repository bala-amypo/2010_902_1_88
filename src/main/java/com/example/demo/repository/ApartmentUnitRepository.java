package com.example.demo.repository;

import com.example.demo.model.ApartmentUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ApartmentUnitRepository extends JpaRepository<ApartmentUnit, Long> {
    List<ApartmentUnit> findByUserId(Long userId);
}
