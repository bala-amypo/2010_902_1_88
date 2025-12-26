package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.ApartmentUnit;
import com.example.demo.repository.ApartmentUnitRepository;
import com.example.demo.service.ApartmentUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApartmentUnitServiceImpl implements ApartmentUnitService {

    private final ApartmentUnitRepository apartmentUnitRepository;

    @Autowired
    public ApartmentUnitServiceImpl(ApartmentUnitRepository apartmentUnitRepository) {
        this.apartmentUnitRepository = apartmentUnitRepository;
    }

    @Override
    public ApartmentUnit assignUnit(Long unitId, ApartmentUnit unitDetails) {
        ApartmentUnit unit = apartmentUnitRepository.findById(unitId)
                .orElseThrow(() -> new ResourceNotFoundException("Apartment unit not found with id: " + unitId));

        // Update unit details as needed
        unit.setNumber(unitDetails.getNumber());
        unit.setFloor(unitDetails.getFloor());
        unit.setStatus(unitDetails.getStatus());
        unit.setType(unitDetails.getType());

        return apartmentUnitRepository.save(unit);
    }

    @Override
    public List<ApartmentUnit> getAllUnits() {
        return apartmentUnitRepository.findAll();
    }

    @Override
    public ApartmentUnit getUnitById(Long unitId) {
        return apartmentUnitRepository.findById(unitId)
                .orElseThrow(() -> new ResourceNotFoundException("Apartment unit not found with id: " + unitId));
    }

    @Override
    public ApartmentUnit createUnit(ApartmentUnit unit) {
        return apartmentUnitRepository.save(unit);
    }

    @Override
    public void deleteUnit(Long unitId) {
        ApartmentUnit unit = apartmentUnitRepository.findById(unitId)
                .orElseThrow(() -> new ResourceNotFoundException("Apartment unit not found with id: " + unitId));
        apartmentUnitRepository.delete(unit);
    }
}
