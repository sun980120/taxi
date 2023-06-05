package com.example.taxiApi.repository;

import com.example.taxiApi.entity.TaxiReserve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxiReserveRepository extends JpaRepository<TaxiReserve, Long> {
}
