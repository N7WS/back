package com.n7ws.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.n7ws.back.entity.HealthInfoEntity;

public interface HealthInfoRepository extends JpaRepository<HealthInfoEntity, String> {

}
