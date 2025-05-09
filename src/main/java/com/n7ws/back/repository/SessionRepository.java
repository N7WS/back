package com.n7ws.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.n7ws.back.entity.SessionEntity;

public interface SessionRepository extends JpaRepository<SessionEntity, String> {

}
