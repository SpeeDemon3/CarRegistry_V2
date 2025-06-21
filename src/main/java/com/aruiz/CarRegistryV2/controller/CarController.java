package com.aruiz.CarRegistryV2.controller;

import com.aruiz.CarRegistryV2.controller.dto.CarRequest;
import com.aruiz.CarRegistryV2.controller.mapper.CarMapper;
import com.aruiz.CarRegistryV2.service.impl.CarServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/car")
@Slf4j
@RequiredArgsConstructor
public class CarController {

    private final CarServiceImpl carService;
    private final CarMapper mapper;

    @PostMapping("/addCar")
    public ResponseEntity<?> save(@RequestBody CarRequest request) {
        try {
            log.info("Car Save from controller.");
            carService.save(request);
            return ResponseEntity.ok().body(request);
        } catch (Exception e) {
            log.error("Error save form controller -> " + e);
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
            return ResponseEntity.ok(carService.updateById(id, request));
        } catch (Exception e) {
            log.error("Error from controller when car update by id");
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
