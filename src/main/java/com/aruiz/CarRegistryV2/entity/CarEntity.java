package com.aruiz.CarRegistryV2.entity;

import com.aruiz.CarRegistryV2.enumsCar.PassengerCapacity;
import com.aruiz.CarRegistryV2.enumsCar.Transmission;
import com.aruiz.CarRegistryV2.enumsCar.Type;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarEntity {

    @Id
    @GeneratedValue
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
