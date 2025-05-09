package com.n7ws.back.entity;

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
public class DeviceConfigEntity implements com.n7ws.back.entity.Entity {
    @Id @GeneratedValue(strategy = GenerationType.UUID) private String uid;
    @ManyToOne
    @NonNull
    private DeviceEntity device;
    @NonNull
    private String cpuName;
    @NonNull
    private Integer cpuCount;
    @NonNull
    private Integer cpuFreq;
    @NonNull
    private Integer ramSize;
    @NonNull
    private Integer ramFreq;
}
