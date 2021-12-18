package com.aacademy.airport_java_advanced_project.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class AirportDto {

    private Long id;

    private String name;

//    private Set<Long> destinationsIds;
}
