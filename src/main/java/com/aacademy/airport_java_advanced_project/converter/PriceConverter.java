package com.aacademy.airport_java_advanced_project.converter;

import com.aacademy.airport_java_advanced_project.dto.PriceDto;
import com.aacademy.airport_java_advanced_project.model.Destination;
import com.aacademy.airport_java_advanced_project.model.Price;
import org.springframework.stereotype.Component;

@Component
public class PriceConverter {

        public PriceDto toPriceDto(Price price){

            return PriceDto.builder()
                    .id(price.getId())
                    .flightPrice(price.getFlightPrice())
                    .destinationId(price.getDestinations().getId())
                    .build();
        }

        public Price toPrice(PriceDto priceDto){

            return Price.builder()
                    .id(priceDto.getId())
                    .flightPrice(priceDto.getFlightPrice())
                    .destinations(Destination.builder()
                            .id(priceDto.getDestinationId())
                            .build())
                    .build();
        }
}
