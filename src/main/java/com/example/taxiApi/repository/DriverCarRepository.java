package com.example.taxiApi.repository;

import com.example.taxiApi.entity.DriverCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverCarRepository extends JpaRepository<DriverCar, Long> {
}
