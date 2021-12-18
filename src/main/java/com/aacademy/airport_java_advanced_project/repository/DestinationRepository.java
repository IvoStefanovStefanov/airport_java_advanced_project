package com.aacademy.airport_java_advanced_project.repository;

import com.aacademy.airport_java_advanced_project.model.Destination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DestinationRepository extends JpaRepository<Destination, Long> {
    Optional<Destination> findByName(String name);
}
