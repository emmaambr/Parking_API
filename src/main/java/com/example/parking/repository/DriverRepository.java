package com.example.parking.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.parking.entity.Driver;

public interface DriverRepository extends CrudRepository<Driver, Long> {

}