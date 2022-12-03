package com.example.parking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.parking.entity.ParkingEvent;

public interface ParkingEventRepository extends CrudRepository<ParkingEvent, Long> {
    
    @Query("""
            SELECT p FROM ParkingEvent p WHERE p.active = :active
        """)  
    List<ParkingEvent> filterActive(@Param("active") Boolean status);

    
}
