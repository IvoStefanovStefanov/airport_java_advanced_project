package com.aacademy.airport_java_advanced_project.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class PriceDto {

    private Long id;

    private Double flightPrice;

    private Long destinationId;
}
