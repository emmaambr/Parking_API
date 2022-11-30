package com.example.parking.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.parking.entity.ParkingEvent;

public interface ParkingEventRepository extends CrudRepository<ParkingEvent, Long> {
    
}