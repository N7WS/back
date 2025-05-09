package com.n7ws.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.n7ws.back.entity.DeviceConfigEntity;

public interface DeviceConfigRepository extends JpaRepository<DeviceConfigEntity, String> {

}