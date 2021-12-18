package com.aacademy.airport_java_advanced_project.service;

import com.aacademy.airport_java_advanced_project.model.Price;

public interface PriceService {

    Price findById(Long id);

    Price save(Price price);

    Price update(Price price, Long id);

    void delete(Long id);

}
