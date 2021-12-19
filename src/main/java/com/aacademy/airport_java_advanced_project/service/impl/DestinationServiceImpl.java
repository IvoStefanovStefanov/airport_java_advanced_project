package com.aacademy.airport_java_advanced_project.service.impl;

import com.aacademy.airport_java_advanced_project.exception.ResourceNotFoundException;
import com.aacademy.airport_java_advanced_project.model.Airport;
import com.aacademy.airport_java_advanced_project.model.Destination;
import com.aacademy.airport_java_advanced_project.repository.DestinationRepository;
import com.aacademy.airport_java_advanced_project.service.AirportService;
import com.aacademy.airport_java_advanced_project.service.DestinationService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class DestinationServiceImpl implements DestinationService {

    private final DestinationRepository destinationRepository;
    private final AirportService airportService;

    public DestinationServiceImpl(DestinationRepository destinationRepository, AirportService airportService) {
        this.destinationRepository = destinationRepository;
        this.airportService = airportService;
    }

    @Override
    public Destination findById(Long id) {
        return destinationRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException(String.format("Destination with this %d id is not found", id)));
    }

    @Override
    public Destination findByName(String name) {
        return destinationRepository.findByName(name)
                .orElseThrow(()->
                        new ResourceNotFoundException(String.format("Destination with this %s name does not exist",name)));
    }

    @Override
    public Destination save(Destination destination) {

        return destinationRepository.save(Destination.builder()
                .name(destination.getName())
                .airports(destination.getAirports())
                .build());
    }

    @Override
    public Destination update(Destination destination, Long id) {
        Destination foundDestination = findById(id);
        Destination destinationToUpdate = Destination.builder()
                .id(foundDestination.getId())
                .name(destination.getName())
                .airports(Airport.builder()
                        .id(destination.getAirports().getId())
                        .build())
                .build();
        return destinationRepository.save(destinationToUpdate);
    }

    @Override
    public void delete(Long id) {
        destinationRepository.deleteById(id);
    }

    @Override
    public Set<Destination> findAll() {
        return new HashSet<>(destinationRepository.findAll());
    }
}
