package com.aacademy.airport_java_advanced_project.repository;

import com.aacademy.airport_java_advanced_project.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {
}
