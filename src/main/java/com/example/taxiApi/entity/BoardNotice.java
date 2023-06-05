package com.example.taxiApi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardNotice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Column(length = 5000)
    private String content;
    private LocalDateTime registerDateTime;
    private LocalDateTime updateDateTime;
    private String writer;
    @PrePersist
    protected void onCreate() {
        LocalDateTime now = LocalDateTime.now();
        registerDateTime = now;
        updateDateTime = now;
    }

    @PreUpdate
    protected void onUpdate() {
        updateDateTime = LocalDateTime.now();
    }
}
