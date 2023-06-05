package com.example.taxiApi.repository;

import com.example.taxiApi.entity.DriverInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverInformationRepository extends JpaRepository<DriverInformation, Long> {
}
