package com.n7ws.back.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity @Data
public class DeviceConfigEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uid;
    @ManyToOne
    private DeviceEntity device;
    private String cpuName;
    private Integer cpuCount;
    private Integer cpuFreq;
    private Integer ramSize;
    private Integer ramFreq;
}
