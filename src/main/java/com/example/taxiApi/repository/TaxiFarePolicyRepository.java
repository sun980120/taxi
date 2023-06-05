package com.example.taxiApi.repository;

import com.example.taxiApi.entity.TaxiFarePolicy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxiFarePolicyRepository extends JpaRepository<TaxiFarePolicy, Long> {
}
