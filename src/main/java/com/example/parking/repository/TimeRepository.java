package com.example.parking.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.parking.entity.Time;

public interface TimeRepository extends CrudRepository<Time, Long> {
    
}