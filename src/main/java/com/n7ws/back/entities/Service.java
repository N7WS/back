package com.n7ws.back.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity @Table(name="services")
public class Service implements Serializable {
    @Id private String uid;

    private String name;

    private Integer port;

    @ManyToMany private Script[] script;

    public Service(String uid, String name, Integer port, Script[] script) {
        this.uid = uid;
        this.name = name;
        this.port = port;
        this.script = script;
    }
}
