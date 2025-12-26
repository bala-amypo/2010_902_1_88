package com.example.demo.service;

import com.example.demo.model.ApartmentUnit;
import java.util.List;

public interface ApartmentUnitService {
    ApartmentUnit addUnit(ApartmentUnit unit);
    ApartmentUnit updateUnit(Long id, ApartmentUnit unit);
    ApartmentUnit getUnitById(Long id);
    List<ApartmentUnit> getAllUnits();
    List<ApartmentUnit> getUnitByUser(Long userId);
    void deleteUnit(Long id);
}
