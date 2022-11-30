package com.example.parking.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.parking.entity.ParkingEvent;

@Service
public interface ParkingEventService {
  
    ParkingEvent getParkingEventById(Long id);
    List<ParkingEvent> getAllParkingEvents(); 
    ParkingEvent newParkingEvent(ParkingEvent parkingEvent); // work in progress
}
