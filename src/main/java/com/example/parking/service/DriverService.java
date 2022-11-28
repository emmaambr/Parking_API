package com.example.parking.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.parking.entity.Driver;

@Service
public interface DriverService {
  
    Driver getDriverById(Long id);
    List<Driver> getAllDrivers(); 
    Driver newDriver(Driver driver);
    
}
