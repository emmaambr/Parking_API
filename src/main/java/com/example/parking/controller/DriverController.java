package com.example.parking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.parking.entity.Driver;
import com.example.parking.service.DriverService;

@RestController
public class DriverController {

    @Autowired
    DriverService driverService;

    @GetMapping("/drivers")
    public ResponseEntity<List<Driver>> getAll() {
            return new ResponseEntity<>(driverService.getAllDrivers(), HttpStatus.OK);
    }

    @GetMapping("/driver/{id}")
    public ResponseEntity<Driver> getDriverById(@PathVariable Long id) {
        return new ResponseEntity<>(driverService.getDriverById(id), HttpStatus.OK);
    }

    @PostMapping("/driver")
    public ResponseEntity<Driver> newDriver(@RequestBody Driver driver) {
        return new ResponseEntity<>(driverService.newDriver(driver), HttpStatus.CREATED);
    }

}
