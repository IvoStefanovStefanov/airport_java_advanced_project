package com.aacademy.airport_java_advanced_project.controller;

import com.aacademy.airport_java_advanced_project.converter.AirportConverter;
import com.aacademy.airport_java_advanced_project.dto.AirportDto;
import com.aacademy.airport_java_advanced_project.model.Airport;
import com.aacademy.airport_java_advanced_project.service.AirportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/airports")
public class AirportController {
    private  final AirportService airportService;
    private final AirportConverter airportConverter;

    public AirportController(AirportService airportService, AirportConverter airportConverter) {
        this.airportService = airportService;
        this.airportConverter = airportConverter;
    }

    @PostMapping
    public ResponseEntity<AirportDto> save(@RequestBody AirportDto airportDto){
        Airport airport = airportConverter.toAirport(airportDto);
        Airport savedAirport = airportService.save(airport);
        AirportDto airportDtoResponse = airportConverter.toAirportDto(savedAirport);
        return ResponseEntity.ok(airportDtoResponse);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AirportDto> findById(@PathVariable Long id){
       Airport foundAirport = airportService.findById(id);
       AirportDto airportDto = airportConverter.toAirportDto(foundAirport);

        return ResponseEntity.ok(airportDto);
    }

    @GetMapping
    public ResponseEntity<Set<AirportDto>> findAll(){
        return ResponseEntity.ok(airportService.findAll()
                .stream()
                        .map(airportConverter::toAirportDto)
                .collect(Collectors.toSet()));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<AirportDto> update(@RequestBody AirportDto airportDto, @PathVariable Long id){
        Airport airport = airportConverter.toAirport(airportDto);
        Airport savedAirport = airportService.update(airport, id);
        AirportDto airportDtoResponse = airportConverter.toAirportDto(savedAirport);
        return ResponseEntity.ok(airportDtoResponse);
    }

    @GetMapping(value = "/name/{name}")
    public ResponseEntity<AirportDto> findByName(@PathVariable String name){
        Airport airport = airportService.findByName(name);
        AirportDto airportDto = airportConverter.toAirportDto(airport);
        return ResponseEntity.ok(airportDto);
    }
}
