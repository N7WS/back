package com.n7ws.back.entities;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity @Table(name="sessions")
public class Session implements Serializable {
    @Id private String uid;

    private String owner_id;

    private User owner;

    private LocalDate expiration;

    public Session(String uid, String owner_id, User owner, LocalDate expiration) {
        this.uid = uid;
        this.owner_id = owner_id;
        this.owner = owner;
        this.expiration = expiration;
    }
}