package com.example.parking.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.parking.entity.Location;

public interface LocationRepository extends CrudRepository<Location, Long> {
    
}