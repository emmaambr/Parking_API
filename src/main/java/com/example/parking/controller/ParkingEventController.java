package com.example.parking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.parking.entity.ParkingEvent;
import com.example.parking.service.ParkingEventService;

@RestController
public class ParkingEventController {
    
    @Autowired
    ParkingEventService parkingEventService;

    @GetMapping("/parkingevents")
    public ResponseEntity<List<ParkingEvent>> getAllParkingEvents() {
            return new ResponseEntity<>(parkingEventService.getAllParkingEvents(), HttpStatus.OK);
    }

    @GetMapping("/parkingevent/{id}")
    public ResponseEntity<ParkingEvent> getParkingEventById(@PathVariable Long id) {
        return new ResponseEntity<>(parkingEventService.getParkingEventById(id), HttpStatus.OK);
    }

    //  work in progress
    @PostMapping("/parkingevent/driver/{driverId}/car/{carId}")
    public ResponseEntity<ParkingEvent> newParkingEvent(@RequestBody ParkingEvent parkingEvent) {
        return new ResponseEntity<>(parkingEventService.newParkingEvent(parkingEvent), HttpStatus.CREATED);
    }

}
