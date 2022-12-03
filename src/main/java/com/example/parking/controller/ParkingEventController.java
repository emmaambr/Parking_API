package com.example.parking.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.parking.entity.Car;
import com.example.parking.entity.Driver;
import com.example.parking.entity.Location;
import com.example.parking.entity.ParkingEvent;
import com.example.parking.repository.ParkingEventRepository;
import com.example.parking.service.CarService;
import com.example.parking.service.DriverService;
import com.example.parking.service.LocationService;
import com.example.parking.service.ParkingEventService;

@RestController
public class ParkingEventController {
    
    @Autowired
    ParkingEventService parkingEventService;
    
    @Autowired
    ParkingEventRepository parkingEventRepository;

    @Autowired
    CarService carService;

    @Autowired
    DriverService driverService;

    @Autowired
    LocationService locationService;

    @GetMapping("/parkingevents")
    public ResponseEntity<List<ParkingEvent>> getAllParkingEvents() {
        return new ResponseEntity<>(parkingEventService.getAllParkingEvents(), HttpStatus.OK);
    }

    @GetMapping("/parkingevent/{id}")
    public ResponseEntity<ParkingEvent> getParkingEventById(@PathVariable Long id) {
        return new ResponseEntity<>(parkingEventService.getParkingEventById(id), HttpStatus.OK);
    }

    @GetMapping("/parkingevent/active/{status}")
    public List<ParkingEvent> getActiveParkingEvents(@PathVariable Boolean status) {
        LocalDateTime now = LocalDateTime.now();
        parkingEventRepository.updateActive(false, now);
        return parkingEventRepository.filterByActive(status);
    }

    @GetMapping("/parkingevent/driver/{id}/active/{status}")
    public List<ParkingEvent> getActiveParkingEvents(@PathVariable Long id, @PathVariable Boolean status) {
        LocalDateTime now = LocalDateTime.now();
        parkingEventRepository.updateActive(false, now);
        return parkingEventRepository.filterByActiveDriver(status, id);
    }

    @PostMapping("/parkingevent") 
    public ResponseEntity<ParkingEvent> newParkingEvent(@RequestBody ParkingEvent parkingEvent,
        @RequestParam(required = true) Long driverId,
        @RequestParam(required = true) Long carId,
        @RequestParam(required = true) Long locationId) {

        Driver driver = driverService.getDriverById(driverId);
        parkingEvent.setDriver(driver);
        Car car = carService.getCarById(carId);
        parkingEvent.setCar(car);
        Location location = locationService.getLocationById(locationId);
        parkingEvent.setLocation(location);

        LocalDateTime startTime = LocalDateTime.now();
        parkingEvent.setStartTime(startTime);
        parkingEvent.setActive(true);

        if(parkingEvent.getEndTime().isAfter(LocalDateTime.now())) {
            var newParkingEvent = parkingEventRepository.save(parkingEvent);
            return ResponseEntity.ok(newParkingEvent);
        } 
        return ResponseEntity.badRequest().build();
    }

}