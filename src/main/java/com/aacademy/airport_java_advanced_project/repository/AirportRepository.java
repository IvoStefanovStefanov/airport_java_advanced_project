package com.aacademy.airport_java_advanced_project.repository;

import com.aacademy.airport_java_advanced_project.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {
    Optional<Airport> findByName(String name);

}
