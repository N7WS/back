package com.n7ws.back.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity @Table(name="scripts")
public class Script implements Serializable {
    @Id private String uid;

    private String name;

    private String path;

    public Script(String uid, String name, String path) {
        this.uid = uid;
        this.name = name;
        this.path = path;
    }
}
