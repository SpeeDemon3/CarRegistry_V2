package com.aruiz.CarRegistryV2.service.converter;

import com.aruiz.CarRegistryV2.controller.dto.CarRequest;
import com.aruiz.CarRegistryV2.controller.dto.CarResponse;
import com.aruiz.CarRegistryV2.entity.CarEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CarConverter {

    public CarResponse toCarResponse(CarEntity entity) {

        CarResponse carResponse = CarResponse.builder()
                .idCar(entity.getIdCar())
                .brand(entity.getBrand())
                .model(entity.getModel())
                .carRegistration(entity.getCarRegistration())
                .engine(entity.getEngine())
                .type(entity.getType())
                .color(entity.getColor())
                .power(entity.getPower())
                .displacement(entity.getDisplacement())
                .transmission(entity.getTransmission())
                .passengerCapacity(entity.getPassengerCapacity())
                .build();

        return carResponse;
    }

    public CarResponse toCarResponse(CarRequest request) {

        CarResponse carResponse = CarResponse.builder()
                .idCar(null)
                .brand(request.getBrand())
                .model(request.getModel())
                .carRegistration(request.getCarRegistration())
                .engine(request.getEngine())
                .type(request.getType())
                .color(request.getColor())
                .power(request.getPower())
                .displacement(request.getDisplacement())
                .transmission(request.getTransmission())
                .passengerCapacity(request.getPassengerCapacity())
                .build();

        return carResponse;
    }

    public CarEntity toCarEntity(CarRequest request) {

        CarEntity entity = CarEntity.builder()
                .idCar(null)
                .brand(request.getBrand())
                .model(request.getModel())
                .carRegistration(request.getCarRegistration())
                .engine(request.getEngine())
                .type(request.getType())
                .color(request.getColor())
                .power(request.getPower())
                .displacement(request.getDisplacement())
                .transmission(request.getTransmission())
                .passengerCapacity(request.getPassengerCapacity())
                .build();

        return entity;

    }

}
