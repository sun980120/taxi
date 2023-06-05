package com.example.taxiApi.repository;

import com.example.taxiApi.entity.UserPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPaymentRepository extends JpaRepository<UserPayment, Long> {
}
