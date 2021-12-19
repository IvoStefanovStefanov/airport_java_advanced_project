package com.aacademy.airport_java_advanced_project.converter;

import com.aacademy.airport_java_advanced_project.dto.DestinationDto;
import com.aacademy.airport_java_advanced_project.model.Airport;
import com.aacademy.airport_java_advanced_project.model.Destination;
import org.springframework.stereotype.Component;

@Component
public class DestinationConverter {

    public DestinationDto toDestinationDto(Destination destination){

        return DestinationDto.builder()
                .id(destination.getId())
                .name(destination.getName())
                .airportId(destination.getAirports().getId())
                .build();
    }

    public Destination toDestination(DestinationDto destinationDto){

        return Destination.builder()
                .id(destinationDto.getId())
                .name(destinationDto.getName())
                .airports(Airport.builder()
                        .id(destinationDto.getAirportId())
                        .build())
                .build();
    }
}
