package com.aacademy.airport_java_advanced_project.dto;

import com.aacademy.airport_java_advanced_project.model.Airport;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class DestinationDto {

    private Long id;

    private String name;

    private Long airportId;
}
