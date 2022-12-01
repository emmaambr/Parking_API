package com.example.parking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.parking.entity.ParkingEvent;
import com.example.parking.repository.CarRepository;
import com.example.parking.repository.DriverRepository;
import com.example.parking.repository.LocationRepository;
import com.example.parking.repository.ParkingEventRepository;

@Service
public class ParkingEventServiceImpl implements ParkingEventService {
    
    @Autowired
    ParkingEventRepository parkingEventRepository;

    @Autowired
    DriverRepository driverRepository;

    @Autowired
    CarRepository carRepository;

    @Autowired
    LocationRepository locationRepository;

    @Override
    public ParkingEvent getParkingEventById(Long id) {
        return parkingEventRepository.findById(id).orElse(null);
    }

    @Override
    public List<ParkingEvent> getAllParkingEvents() {
        return (List<ParkingEvent>)parkingEventRepository.findAll();
    }
          
}