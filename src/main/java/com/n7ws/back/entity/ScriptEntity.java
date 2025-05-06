package com.n7ws.back.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class ScriptEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uid;
    private String name;
    private String path;
}
