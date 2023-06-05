package com.example.taxiApi.repository;

import com.example.taxiApi.entity.BoardNotice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardNoticeRepository extends JpaRepository<BoardNotice, Long> {
}
