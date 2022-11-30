package com.example.parking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.parking.entity.Location;
import com.example.parking.repository.LocationRepository;

@Service
public class LocationServiceImpl implements LocationService {
    
    @Autowired
    LocationRepository locationRepository;

    @Override
    public Location getLocationById(Long id) {
        return locationRepository.findById(id).orElse(null);
    }

    @Override
    public List<Location> getAllLocations() {
        return (List<Location>)locationRepository.findAll();
    }

    @Override
    public Location newLocation(Location location) {
        return locationRepository.save(location);
    }
    
}
