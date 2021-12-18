package com.aacademy.airport_java_advanced_project.converter;

import com.aacademy.airport_java_advanced_project.dto.AirportDto;
import com.aacademy.airport_java_advanced_project.model.Airport;
import org.springframework.stereotype.Component;

@Component
public class AirportConverter {

    public AirportDto toAirportDto(Airport airport){
        return AirportDto.builder()
                .id(airport.getId())
                .name(airport.getName())
                .build();
    }

    public Airport toAirport(AirportDto airportDto){
        return Airport.builder()
                .id(airportDto.getId())
                .name(airportDto.getName())
                .build();
    }
}
