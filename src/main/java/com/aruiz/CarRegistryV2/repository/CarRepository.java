package com.aruiz.CarRegistryV2.repository;

import com.aruiz.CarRegistryV2.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, Long> {
}
