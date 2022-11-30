package com.example.parking.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.parking.entity.Location;
import com.example.parking.repository.LocationRepository;
import com.example.parking.service.LocationService;

@RestController
public class LocationController {
    
    LocationRepository locationRepository;
    LocationService locationService;

    public LocationController(LocationRepository locationRepository, LocationService locationService) {
        this.locationRepository = locationRepository; 
        this.locationService = locationService;
    }

    @GetMapping("/locations")
    public ResponseEntity<List<Location>> getAllLocations() {
            return new ResponseEntity<>(locationService.getAllLocations(), HttpStatus.OK);
    }

    @GetMapping("/location/{id}") 
    public ResponseEntity<Location> getLocationById(@PathVariable Long id) {
        return new ResponseEntity<>(locationService.getLocationById(id), HttpStatus.OK);
    }

    @PostMapping("/location")
    public ResponseEntity<Location> newLocation(@RequestBody Location location) {
        return new ResponseEntity<>(locationService.newLocation(location), HttpStatus.CREATED);
    }

}
