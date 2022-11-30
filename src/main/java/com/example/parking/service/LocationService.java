package com.example.parking.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.parking.entity.Location;

@Service
public interface LocationService {
  
    Location getLocationById(Long id);
    List<Location> getAllLocations(); 
    Location newLocation(Location location);
    
}
