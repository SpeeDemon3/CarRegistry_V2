package com.aruiz.CarRegistryV2.service.impl;

import com.aruiz.CarRegistryV2.controller.dto.CarRequest;
import com.aruiz.CarRegistryV2.controller.dto.CarResponse;
import com.aruiz.CarRegistryV2.entity.CarEntity;
import com.aruiz.CarRegistryV2.repository.CarRepository;
import com.aruiz.CarRegistryV2.service.CarService;
import com.aruiz.CarRegistryV2.service.converter.CarConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository repository;

    @Autowired
    private CarConverter converter;

    @Override
    public CarResponse save(CarRequest car) throws Exception {

        if (car != null) {
            CarEntity entity = converter.toCarEntity(car);
            repository.save(entity);
            log.info("Car save");
            return converter.toCarResponse(entity);
        }

        return null;
    }

    @Override
    public CarResponse findById(Long id) throws Exception {

        Optional<CarEntity> entity = repository.findById(id);

        if (entity.isPresent()) {

            CarResponse response = converter.toCarResponse(entity.get());
            log.info("Car find");
            return response;
        }

        return null;
    }

    @Override
    public List<CarResponse> findAll() throws Exception {

        List<CarEntity> list = repository.findAll();

        if(!list.isEmpty()) {
            List<CarResponse> responseList = new ArrayList<>();

            for (CarEntity entity : list) {
                responseList.add(converter.toCarResponse(entity));
            }

            return responseList;
        }

        return null;
    }

    @Override
    public CarResponse updateById(Long id, CarRequest request) throws Exception {

        Optional<CarEntity> entityOptional = repository.findById(id);

        if (entityOptional.isPresent()) {

            CarEntity entity = entityOptional.get();

            entity.setIdCar(id);
            entity.setBrand(request.getBrand());
            entity.setModel(request.getModel());
            entity.setCarRegistration(request.getCarRegistration());
            entity.setEngine(request.getEngine());
            entity.setType(request.getType());
            entity.setColor(request.getColor());
            entity.setPower(request.getPower());
            entity.setDisplacement(request.getDisplacement());
            entity.setTransmission(request.getTransmission());
            entity.setPassengerCapacity(request.getPassengerCapacity());

            repository.save(entity);

            return converter.toCarResponse(entity);
        }

        return null;
    }

    @Override
    public boolean removeById(Long id) throws Exception {

        if (repository.findById(id).isPresent()) {
            repository.deleteById(id);
            log.info("Car delete");
            return true;
        }

        return false;
    }
}
