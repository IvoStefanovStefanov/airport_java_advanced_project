package com.aacademy.airport_java_advanced_project.service.impl;

import com.aacademy.airport_java_advanced_project.exception.ResourceNotFoundException;
import com.aacademy.airport_java_advanced_project.model.Airport;
import com.aacademy.airport_java_advanced_project.repository.AirportRepository;
import com.aacademy.airport_java_advanced_project.service.AirportService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AirportServiceImpl implements AirportService {

    private final AirportRepository airportRepository;

    public AirportServiceImpl(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    @Override
    public Airport findById(Long id) {
        return airportRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException(String.format("Airport with this %d  is not found", id)));
    }

    @Override
    public Airport save(Airport airport) {

        return airportRepository.save(Airport.builder()
                .name(airport.getName())
                .build());
    }

    @Override
    public Airport update(Airport airport, Long id) {
        Airport foundAirport = findById(id);
        Airport updatedAirport = Airport.builder()
                .id(foundAirport.getId())
                .name(airport.getName())
                .build();
        return airportRepository.save(updatedAirport);
    }

    @Override
    public Airport findByName(String name) {
        return airportRepository.findByName(name)
                .orElseThrow(()->
                        new ResourceNotFoundException(String.format("Airport with this %s name does not exist",name)));
    }

    @Override
    public Set<Airport> findAll() {
        return new HashSet<>(airportRepository.findAll());
    }

}

