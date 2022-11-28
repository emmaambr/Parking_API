package com.example.parking.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.parking.entity.Car;

@Service
public interface CarService {
  
    List<Car> getAllCars(); 
    Car newCar(Car car);
    Car addCarDriver(Long carId, Long driverId);

}

    