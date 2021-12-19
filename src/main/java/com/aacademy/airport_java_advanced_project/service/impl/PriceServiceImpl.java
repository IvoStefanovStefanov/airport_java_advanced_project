package com.aacademy.airport_java_advanced_project.service.impl;

import com.aacademy.airport_java_advanced_project.exception.ResourceNotFoundException;
import com.aacademy.airport_java_advanced_project.model.Destination;
import com.aacademy.airport_java_advanced_project.model.Price;
import com.aacademy.airport_java_advanced_project.repository.PriceRepository;
import com.aacademy.airport_java_advanced_project.service.PriceService;
import org.springframework.stereotype.Service;

@Service
public class PriceServiceImpl implements PriceService {

    private final PriceRepository priceRepository;

    public PriceServiceImpl(PriceRepository priceRepository) {

        this.priceRepository = priceRepository;
    }

    @Override
    public Price findById(Long id) {
        return priceRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException(String.format("Price with %d id does not exist", id)));
    }

    @Override
    public Price save(Price price) {

        return priceRepository.save(Price.builder()
                .flightPrice(price.getFlightPrice())
                .destinations(price.getDestinations())
                .build());
    }

    @Override
    public Price update(Price price, Long id) {

        Price foundPrice = findById(id);
        Price priceToUpdate = Price.builder()
                .id(foundPrice.getId())
                .flightPrice(price.getFlightPrice())
                .destinations(Destination.builder()
                        .id(price.getDestinations().getId())
                        .build())
                .build();
        return priceRepository.save(priceToUpdate);
    }

    @Override
    public void delete(Long id) {
        priceRepository.deleteById(id);
    }
}
