package com.aacademy.airport_java_advanced_project.service;

import com.aacademy.airport_java_advanced_project.model.Destination;

import java.util.Set;

public interface DestinationService {

    Destination findById(Long id);

    Destination findByName(String name);

    Destination save(Destination destination);

    Destination update(Destination destination, Long id);

    void delete(Long id);

    Set<Destination> findAll();
}
