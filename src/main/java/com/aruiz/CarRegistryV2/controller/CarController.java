package com.aruiz.CarRegistryV2.controller;

import com.aruiz.CarRegistryV2.service.impl.CarServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/car")
@Slf4j
@RequiredArgsConstructor
public class CarController {

    private final CarServiceImpl carService;
    

}
