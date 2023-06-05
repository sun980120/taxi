package com.example.taxiApi.repository;

import com.example.taxiApi.entity.CarInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarInformationRepository extends JpaRepository<CarInformation, Long> {
}
