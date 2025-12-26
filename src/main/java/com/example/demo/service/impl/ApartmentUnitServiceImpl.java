package com.example.demo.service.impl;

import com.example.demo.model.ApartmentUnit;
import com.example.demo.model.User;
import com.example.demo.repository.ApartmentUnitRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.ApartmentUnitService;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.NotFoundException;

import org.springframework.stereotype.Service;

@Service
public class ApartmentUnitServiceImpl implements ApartmentUnitService {

    private final ApartmentUnitRepository unitRepo;
    private final UserRepository userRepo;

    public ApartmentUnitServiceImpl(ApartmentUnitRepository unitRepo,
                                    UserRepository userRepo) {
        this.unitRepo = unitRepo;
        this.userRepo = userRepo;
    }

    @Override
    public ApartmentUnit assignUnit(Long userId, ApartmentUnit unit) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new NotFoundException("User not found"));

        if (unit.getId() != null) {
            throw new BadRequestException("New unit cannot already have an ID");
        }

        unit.setOwner(user);
        return unitRepo.save(unit);
    }
}
