package com.example.demo.service.impl;

import com.example.demo.service.FacilityService;
import com.example.demo.model.Facility;
import com.example.demo.repository.FacilityRepository;
import com.example.demo.exception.BadRequestException;

import java.util.List;

public class FacilityServiceImpl implements FacilityService {

    private final FacilityRepository facilityRepository;

    public FacilityServiceImpl(FacilityRepository facilityRepository) {
        this.facilityRepository = facilityRepository;
    }

    @Override
    public Facility addFacility(Facility facility) {
        if (facility.getOpenTime().compareTo(facility.getCloseTime()) >= 0) {
            throw new BadRequestException("time invalid");
        }
        return facilityRepository.save(facility);
    }

    @Override
    public List<Facility> getAllFacilities() {
        return facilityRepository.findAll();
    }
}
