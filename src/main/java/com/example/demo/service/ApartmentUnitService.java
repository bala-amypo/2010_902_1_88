package com.example.demo.service;

import com.example.demo.model.ApartmentUnit;
import java.util.List;

public interface ApartmentUnitService {

    ApartmentUnit assignUnit(Long unitId, ApartmentUnit unitDetails);

    List<ApartmentUnit> getAllUnits();

    ApartmentUnit getUnitById(Long unitId);

    ApartmentUnit getUnitByUser(Long userId);

    ApartmentUnit createUnit(ApartmentUnit unit);

    void deleteUnit(Long unitId);
}
