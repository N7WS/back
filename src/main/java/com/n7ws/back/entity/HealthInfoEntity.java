package com.n7ws.back.entity;

import java.util.Collection;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class HealthInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uid;
    @ManyToOne
    private DeviceEntity device;
    private Collection<Integer> ping;
    private Collection<Integer> ram;
    private Collection<Integer> cpu;
}