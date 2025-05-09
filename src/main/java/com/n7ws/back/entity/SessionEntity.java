package com.n7ws.back.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity @Data @AllArgsConstructor @RequiredArgsConstructor @NoArgsConstructor
public class SessionEntity implements com.n7ws.back.entity.Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uid;
    @ManyToOne
    @NonNull
    private UserEntity owner;
    @NonNull
    private LocalDate expiration;
}