package com.example.parking.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.parking.entity.ParkingEvent;

import jakarta.transaction.Transactional;

public interface ParkingEventRepository extends CrudRepository<ParkingEvent, Long> {
    
    @Query("""
            SELECT p FROM ParkingEvent p WHERE p.active = :active
        """)  
    List<ParkingEvent> filterByActive(@Param("active") Boolean status);

    @Query("""
            SELECT p FROM ParkingEvent p WHERE p.active = :active AND p.driver.id = :id
        """)  
    List<ParkingEvent> filterByActiveDriver(@Param("active") Boolean status, @Param("id") Long id);

    @Transactional
    @Modifying
    @Query("UPDATE ParkingEvent p SET p.active = :active WHERE p.endTime < :now")
        void updateActive(@Param("active") Boolean status, @Param("now") LocalDateTime now);  
        
}
