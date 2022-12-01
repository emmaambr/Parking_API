package com.example.parking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.example.parking.entity.ParkingEvent;

public interface ParkingEventRepository extends CrudRepository<ParkingEvent, Long> {
    
    @Query("""
            SELECT p FROM ParkingEvent p WHERE (p.active) = true
        """)  
    List<ParkingEvent> filterActive();

    @Query("""
            SELECT p FROM ParkingEvent p WHERE (p.active) = false
        """)
    List<ParkingEvent> filterExpired();
}
