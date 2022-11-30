package com.example.parking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.parking.entity.ParkingEvent;
import com.example.parking.repository.ParkingEventRepository;

@Service
public class ParkingEventServiceImpl implements ParkingEventService {
    
    @Autowired
    ParkingEventRepository parkingEventRepository;

    @Override
    public ParkingEvent getParkingEventById(Long id) {
        return parkingEventRepository.findById(id).orElse(null);
    }

    @Override
    public List<ParkingEvent> getAllParkingEvents() {
        return (List<ParkingEvent>)parkingEventRepository.findAll();
    }

    // work in progress
    @Override
    public ParkingEvent newParkingEvent(ParkingEvent parkingEvent) {
        return parkingEventRepository.save(parkingEvent);
    }
          

}