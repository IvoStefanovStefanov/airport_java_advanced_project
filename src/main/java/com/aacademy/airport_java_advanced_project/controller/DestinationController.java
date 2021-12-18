package com.aacademy.airport_java_advanced_project.controller;

import com.aacademy.airport_java_advanced_project.converter.DestinationConverter;
import com.aacademy.airport_java_advanced_project.dto.DestinationDto;
import com.aacademy.airport_java_advanced_project.model.Destination;
import com.aacademy.airport_java_advanced_project.service.DestinationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/destinations")
public class DestinationController {

    private final DestinationService destinationService;
    private final DestinationConverter destinationConverter;

    public DestinationController(DestinationService destinationService, DestinationConverter destinationConverter) {
        this.destinationService = destinationService;
        this.destinationConverter = destinationConverter;
    }
    @PostMapping
    public ResponseEntity<DestinationDto> save(@RequestBody DestinationDto destinationDto){
        Destination destination = destinationConverter.toDestination(destinationDto);
        Destination savedDestination = destinationService.save(destination);
        DestinationDto destinationDtoResponse = destinationConverter.toDestinationDto(savedDestination);
        return ResponseEntity.ok(destinationDtoResponse);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<DestinationDto> findById(@PathVariable Long id){
        Destination foundDestination = destinationService.findById(id);
        DestinationDto destinationDto = destinationConverter.toDestinationDto(foundDestination);
        return ResponseEntity.ok(destinationDto);
    }

    @GetMapping(value = "/name/{name}")
    public ResponseEntity<DestinationDto> findByName(@PathVariable String name){
        Destination destination = destinationService.findByName(name);
        DestinationDto destinationDto = destinationConverter.toDestinationDto(destination);
        return ResponseEntity.ok(destinationDto);
    }

    @GetMapping
    public ResponseEntity<Set<DestinationDto>> findAll(){
        return ResponseEntity.ok(destinationService.findAll()
                .stream()
                .map(destinationConverter::toDestinationDto)
                .collect(Collectors.toSet()));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id){
        destinationService.delete(id);
        return ResponseEntity.ok().build();
    }

}
