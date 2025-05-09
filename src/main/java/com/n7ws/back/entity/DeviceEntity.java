package com.n7ws.back.entity;

import java.util.Collection;

import com.n7ws.back.enums.DeviceState;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class DeviceEntity implements com.n7ws.back.entity.Entity {
    @Id
    private String name;
    private DeviceState status;
    private String room;
    @ManyToMany
    private Collection<ServiceEntity> services;
    @OneToMany
    private Collection<HealthInfoEntity> healthInfos;
    @OneToMany
    private Collection<DeviceConfigEntity> deviceConfigs;

    public String getUid() {
        return name;
    }
}