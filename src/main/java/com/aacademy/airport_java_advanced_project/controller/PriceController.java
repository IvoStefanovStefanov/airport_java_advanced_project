package com.aacademy.airport_java_advanced_project.controller;

import com.aacademy.airport_java_advanced_project.converter.PriceConverter;
import com.aacademy.airport_java_advanced_project.dto.PriceDto;
import com.aacademy.airport_java_advanced_project.model.Price;
import com.aacademy.airport_java_advanced_project.service.PriceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/prices")
public class PriceController {

    private final PriceService priceService;
    private final PriceConverter priceConverter;

    public PriceController(PriceService priceService, PriceConverter priceConverter) {
        this.priceService = priceService;
        this.priceConverter = priceConverter;
    }

    @PostMapping
    public ResponseEntity<PriceDto> save(@RequestBody PriceDto priceDto){
        Price price = priceConverter.toPrice(priceDto);
        Price savedPrice = priceService.save(price);
        PriceDto priceDtoResponse = priceConverter.toPriceDto(savedPrice);
        return ResponseEntity.ok(priceDtoResponse);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PriceDto> findById(@PathVariable Long id){
        Price foundPrice = priceService.findById(id);
        PriceDto priceDto = priceConverter.toPriceDto(foundPrice);

        return ResponseEntity.ok(priceDto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PriceDto> update(@RequestBody PriceDto priceDto, @PathVariable Long id){
        Price price = priceConverter.toPrice(priceDto);
        Price savedPrice = priceService.update(price, id);
        PriceDto priceDtoResponse = priceConverter.toPriceDto(savedPrice);
        return ResponseEntity.ok(priceDtoResponse);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id){
        priceService.delete(id);
        return ResponseEntity.ok().build();
    }
}
