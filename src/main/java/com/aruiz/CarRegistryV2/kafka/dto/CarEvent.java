package com.aruiz.CarRegistryV2.kafka.dto;

import com.aruiz.CarRegistryV2.controller.dto.CarResponse;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CarEvent {
    private String eventType; // "CAR_CREATED", "CAR_UPDATED", "CAR_DELETED"
    private CarResponse car;
}
