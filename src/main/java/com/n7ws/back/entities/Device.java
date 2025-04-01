package com.n7ws.back.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity @Table(name="devices")
public class Device implements Serializable {
    @Id private String name;

    private Status status;

    private String room;

    @ManyToMany private Service[] services;

    public Device(String name, Status status, String room, Service[] services) {
        this.name = name;
        this.status = status;
        this.room = room;
        this.services = services;
    }
}