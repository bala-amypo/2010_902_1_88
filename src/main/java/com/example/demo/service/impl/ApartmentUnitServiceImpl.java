package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.ApartmentUnit;
import com.example.demo.repository.ApartmentUnitRepository;
import com.example.demo.service.ApartmentUnitService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApartmentUnitServiceImpl implements ApartmentUnitService {

    private final ApartmentUnitRepository apartmentUnitRepository;

    public ApartmentUnitServiceImpl(ApartmentUnitRepository apartmentUnitRepository) {
        this.apartmentUnitRepository = apartmentUnitRepository;
    }

    @Override
    public ApartmentUnit addUnit(ApartmentUnit unit) {
        return apartmentUnitRepository.save(unit);
    }

    @Override
    public ApartmentUnit updateUnit(Long id, ApartmentUnit unit) {
        ApartmentUnit existing = getUnitById(id);
        existing.setUnitNumber(unit.getUnitNumber());
        existing.setStatus(unit.getStatus());
        existing.setType(unit.getType());
        existing.setFloor(unit.getFloor());
        existing.setUserId(unit.getUserId());
        return apartmentUnitRepository.save(existing);
    }

    @Override
    public ApartmentUnit getUnitById(Long id) {
        return apartmentUnitRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ApartmentUnit not found with id " + id));
    }

    @Override
    public List<ApartmentUnit> getAllUnits() {
        return apartmentUnitRepository.findAll();
    }

    @Override
    public List<ApartmentUnit> getUnitByUser(Long userId) {
        return apartmentUnitRepository.findByUserId(userId);
    }

    @Override
    public void deleteUnit(Long id) {
        ApartmentUnit existing = getUnitById(id);
        apartmentUnitRepository.delete(existing);
    }
}
