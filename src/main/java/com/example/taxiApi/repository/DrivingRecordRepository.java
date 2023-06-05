package com.example.taxiApi.repository;

import com.example.taxiApi.entity.DrivingRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrivingRecordRepository extends JpaRepository<DrivingRecord, Long> {
}
