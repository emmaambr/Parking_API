package com.example.parking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.parking.entity.Car;
import com.example.parking.service.CarService;
import com.example.parking.service.DriverService;


@RestController
public class CarController {

    @Autowired
    CarService carService;

    @Autowired
    DriverService driverService;

    public CarController(CarService carService, DriverService driverService) {
        this.carService = carService;
        this.driverService = driverService;
    }

    @GetMapping("/cars")
    public ResponseEntity<List<Car>> getAll() {
            return new ResponseEntity<>(carService.getAllCars(), HttpStatus.OK);
    }

    @PostMapping("/car")
    public ResponseEntity<Car> newCar(@RequestBody Car car) {
        return new ResponseEntity<>(carService.newCar(car), HttpStatus.CREATED);
    }

    @PutMapping("/car/{id}")
    public ResponseEntity<Car> addDriver(@PathVariable("id") Long carId, @RequestParam(required = true) Long driverId) {
        return new ResponseEntity<>(carService.addCarDriver(carId, driverId), HttpStatus.OK);
    }

}
