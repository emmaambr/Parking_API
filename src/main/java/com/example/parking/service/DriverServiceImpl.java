package com.example.parking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.parking.entity.Driver;
import com.example.parking.repository.DriverRepository;

@Service
public class DriverServiceImpl implements DriverService {
    
    @Autowired
    DriverRepository driverRepository;

    @Override
    public Driver getDriverById(Long id) {
        return driverRepository.findById(id).orElse(null);
    }

    @Override
    public List<Driver> getAllDrivers() {
        return (List<Driver>)driverRepository.findAll();
    }

    @Override
    public Driver newDriver(Driver driver) {
        return driverRepository.save(driver);
    }
}
