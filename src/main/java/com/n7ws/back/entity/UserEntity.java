package com.n7ws.back.entity;

import java.util.Collection;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity @Data @RequiredArgsConstructor @NoArgsConstructor
public class UserEntity implements com.n7ws.back.entity.Entity {
    @Id
    @NonNull
    private String uid;
    @NonNull
    private String lastname;
    @NonNull
    private String firstname;
    @NonNull
    private String password;
    @OneToMany
    @NonNull
    private Collection<SessionEntity> sessions;
    @NonNull
    private Boolean admin;
}