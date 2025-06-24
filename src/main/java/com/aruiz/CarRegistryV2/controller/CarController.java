package com.aruiz.CarRegistryV2.controller;

import com.aruiz.CarRegistryV2.controller.dto.CarRequest;
import com.aruiz.CarRegistryV2.controller.dto.CarResponse;
import com.aruiz.CarRegistryV2.controller.mapper.CarMapper;
import com.aruiz.CarRegistryV2.entity.CarEntity;
import com.aruiz.CarRegistryV2.kafka.dto.CarEvent;
import com.aruiz.CarRegistryV2.service.impl.CarServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/car")
@Slf4j
@RequiredArgsConstructor
public class CarController {

    private final CarServiceImpl carService;
    private final CarMapper mapper;
    private final KafkaTemplate<String, CarEvent> kafkaTemplate;

    private static final String CAR_EVENTS_TOPIC = "car-events";


    @PostMapping("/addCar")
    public ResponseEntity<?> save(@RequestBody CarRequest request) {
        try {
            log.info("Saving car from controller.");
            CarResponse response = carService.save(request);

            try {
                // Public event
                kafkaTemplate.send(
                        "car-events",
                        CarEvent.builder()
                                .eventType("CAR_CREATED")
                                .car(response)
                                .build()
                );
                log.info("Event published to Kafka successfully");
            } catch (Exception e) {
                log.error("Failed to publish Kafka event: " + e);
            }

            return ResponseEntity.ok().body(request);

        } catch (Exception e) {
            log.error("Error save form controller -> {}", String.valueOf(e));
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/getCar/{id}")
    public ResponseEntity<?> getCarById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(carService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> getAllCars() {
        try {
            return ResponseEntity.ok(carService.findAll());
        } catch (Exception e) {
            log.error("Error in controller: " + e);
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/updateById/{id}")
    public ResponseEntity<?> updateById(@RequestBody CarRequest request, @PathVariable Long id) {
        try {
            log.info("Update car from Controller");
            CarResponse updatedCarResponse = carService.updateById(id, request);

            try {
                kafkaTemplate.send(
                    CAR_EVENTS_TOPIC,
                    CarEvent.builder()
                            .eventType("CAR_UPDATED")
                            .car(updatedCarResponse)
                            .build()
                );
                log.info("Event CAR_UPDATED published to Kafka successfully for car ID: {}", updatedCarResponse.getIdCar());

            } catch (Exception e) {
                log.error("Failed to publish CAR_UPDATED Kafka event for car ID: {}. Error: {}", updatedCarResponse.getIdCar(), e.getMessage());

            }

            return ResponseEntity.ok(updatedCarResponse);

        } catch (Exception e) {
            log.error("Error from controller when car update by ID {}: {}", id, e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(carService.removeById(id));
        } catch (Exception e) {
            log.info("Car not found from controller");
            return ResponseEntity.notFound().build();
        }
    }

}
