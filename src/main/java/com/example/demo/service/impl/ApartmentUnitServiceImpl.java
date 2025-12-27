package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.ApartmentUnitModel;
import com.example.demo.model.UserModel;
import com.example.demo.repository.ApartmentUnitRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.ApartmentUnitService;
import org.springframework.stereotype.Service;

@Service
public class ApartmentUnitServiceImpl implements ApartmentUnitService {

    private final ApartmentUnitRepository unitRepository;
    private final UserRepository userRepository;

    public ApartmentUnitServiceImpl(ApartmentUnitRepository unitRepository,
                                    UserRepository userRepository) {
        this.unitRepository = unitRepository;
        this.userRepository = userRepository;
    }

    @Override
    public ApartmentUnitModel assignUnitToUser(Long userId, ApartmentUnitModel unit) {
        UserModel user = userRepository.findById(userId)
                .orElseThrow(() -> new BadRequestException("Invalid user"));

        unit.setOwner(user);
        user.setApartmentUnit(unit);

        return unitRepository.save(unit);
    }

    @Override
    public ApartmentUnitModel getUnitByUser(Long userId) {
        UserModel user = userRepository.findById(userId)
                .orElseThrow(() -> new BadRequestException("Invalid user"));
        return unitRepository.findByOwner(user)
                .orElseThrow(() -> new BadRequestException("Unit not found"));
    }
}