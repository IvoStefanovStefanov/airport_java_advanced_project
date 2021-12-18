package com.aacademy.airport_java_advanced_project.service;

import com.aacademy.airport_java_advanced_project.model.Airport;

import java.util.Set;

public interface AirportService {

    Airport findById(Long id);

    Airport save(Airport airport);

    Airport update(Airport airport, Long id);

    Airport findByName(String name);

    Set<Airport> findAll();

    void delete(Long id);
}
