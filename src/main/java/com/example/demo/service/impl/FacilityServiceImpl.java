package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.Facility;
import com.example.demo.repository.FacilityRepository;
import com.example.demo.service.FacilityService;

import java.util.List;

public class FacilityServiceImpl implements FacilityService {

    private final FacilityRepository repo;

    public FacilityServiceImpl(FacilityRepository repo) {
        this.repo = repo;
    }

    @Override
    public Facility addFacility(Facility f) {
        if (f.getOpenTime().compareTo(f.getCloseTime()) >= 0) {
            throw new BadRequestException("time invalid");
        }
        return repo.save(f);
    }

    @Override
    public List<Facility> getAllFacilities() {
        return repo.findAll();
    }
}
