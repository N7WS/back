package com.n7ws.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.n7ws.back.entity.DeviceEntity;

public interface DeviceRepository extends JpaRepository<DeviceEntity, String> {

}
