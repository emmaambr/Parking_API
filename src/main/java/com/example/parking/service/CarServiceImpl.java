package com.example.parking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.parking.entity.Car;
import com.example.parking.entity.Driver;
import com.example.parking.repository.CarRepository;

@Service
public class CarServiceImpl implements CarService {
    
    @Autowired
    CarRepository carRepository;

    @Autowired
    DriverService driverService;

    @Override
    public Car getCarById(Long id) {
        return carRepository.findById(id).orElse(null);
    }

    @Override
    public List<Car> getAllCars() {
        return (List<Car>)carRepository.findAll();
    }

    @Override
    public Car newCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Car addCarDriver(Long carId, Long driverId) {
        Optional<Car> carOptional = carRepository.findById(carId);
        Driver driver = driverService.getDriverById(driverId);

        if (carOptional.isPresent() && driver != null) {
            Car c = carOptional.get();
            c.setDriver(driver);
            return c;
        } 
        return null;
    }
    
}
