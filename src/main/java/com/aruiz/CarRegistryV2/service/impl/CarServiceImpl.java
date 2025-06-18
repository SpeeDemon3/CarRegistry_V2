package com.aruiz.CarRegistryV2.service.impl;

import com.aruiz.CarRegistryV2.controller.dto.CarRequest;
import com.aruiz.CarRegistryV2.controller.dto.CarResponse;
import com.aruiz.CarRegistryV2.repository.CarRepository;
import com.aruiz.CarRegistryV2.service.CarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository repository;

    @Override
    public CarResponse save(CarRequest car) throws Exception {
        return null;
    }

    @Override
    public CarResponse findById(Long id) throws Exception {
        return null;
    }

    @Override
    public List<CarResponse> findAll() throws Exception {
        return List.of();
    }

    @Override
    public CarResponse updateById(Long id, CarRequest request) throws Exception {
        return null;
    }

    @Override
    public boolean removeById(Long id) throws Exception {
        return false;
    }
}
