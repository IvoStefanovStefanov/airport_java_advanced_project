package com.aacademy.airport_java_advanced_project.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class DestinationDto {

    private Long id;

    private String name;

    private Long airportId;
}
