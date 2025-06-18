package com.aruiz.CarRegistryV2.controller.dto;

import com.aruiz.CarRegistryV2.enumsCar.PassengerCapacity;
import com.aruiz.CarRegistryV2.enumsCar.Transmission;
import com.aruiz.CarRegistryV2.enumsCar.Type;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CarResponse {
    private Long idCar;
    private String brand;
    private String model;
    private String carRegistration;
    private String engine;
    private Type type;
    private String color;
    private Integer power;
    private Float displacement;
    private Transmission transmission;
    private PassengerCapacity passengerCapacity;
}
