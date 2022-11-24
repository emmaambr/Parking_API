package com.example.parking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Location {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    // Apply spatial data for this entity

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
