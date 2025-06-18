package com.aruiz.CarRegistryV2.service;

import com.aruiz.CarRegistryV2.controller.dto.CarRequest;
import com.aruiz.CarRegistryV2.controller.dto.CarResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarService {
    CarResponse save(CarRequest car) throws Exception;
    CarResponse findById(Long id) throws Exception;
    List<CarResponse> findAll() throws Exception;
    CarResponse updateById(Long id, CarRequest request) throws Exception;
    boolean removeById(Long id) throws Exception;
}
