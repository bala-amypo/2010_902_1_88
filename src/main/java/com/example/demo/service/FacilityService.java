package com.example.demo.service;

import com.example.demo.model.Facility;
import java.util.List;

public interface FacilityService {
    Facility createFacility(Facility facility);
    Facility getFacilityById(Long id);
    List<Facility> getAllFacilities();
    Facility updateFacility(Long id, Facility facility);
    void deleteFacility(Long id);
}
