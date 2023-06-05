package com.example.taxiApi.repository;

import com.example.taxiApi.entity.UserInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInformationRepository extends JpaRepository<UserInformation, Long> {
    UserInformation findByUserEmail(String userEmail);

    boolean existsByUserEmail(String userEmail);
}
